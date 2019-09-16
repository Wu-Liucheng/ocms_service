package com.ocms.service.impl;

import com.ocms.dao.*;
import com.ocms.entities.*;
import com.ocms.service.CheckerService;
import com.ocms.util.MD5Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CheckerServiceImpl implements CheckerService {

    @Resource
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Resource
    private CheckerMapper checkerMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private SignUpInfoMapper signUpInfoMapper;

    @Resource
    private DemandMapper demandMapper;

    @Resource
    private ResumeMapper resumeMapper;

    @Resource
    private UserBindToDemandMapper userBindToDemandMapper;

    @Resource
    private ProjectMapper projectMapper;

    @Resource
    private ClientMapper clientMapper;

    @Override
    public ReturnDataAndInfo verifyIsLegal(String loginName, String password) {
        Checker checker = checkerMapper.selectByLoginName(loginName);
        if(checker!=null)
            if(MD5Util.verify(password,checker.getPassword()))
                return new ReturnDataAndInfo(true,"");
        return new ReturnDataAndInfo(false,"用户名或密码错误");
    }

    @Override
    public Long getIdByLoginName(String loginName) {
        Checker checker = checkerMapper.selectByLoginName(loginName);
        if(checker == null)
            return null;
        return checker.getId();
    }

    @Override
    public ReturnDataAndInfo checkAction(Boolean isPassed, Long userId, String username,
                                         Long demandId, Long objectId, Long checkerId,
                                         String content) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        String registerEmail = userInfo.getEmail();
        Demand demand = demandMapper.selectByPrimaryKey(demandId);
        if(isPassed){
            SignUpInfo signUpInfo = new SignUpInfo(userId,demandId,0,null,null,checkerId,new Date());
            int ret1 = signUpInfoMapper.updateByPrimaryKeySelective(signUpInfo);
            if(ret1>0){
                UserBindToDemand u = userBindToDemandMapper.findUserIsBeingUsed(userId);
                if(u!=null){
                    SignUpInfo signUpInfo1 = new SignUpInfo(userId,demandId,1,null,null,checkerId,new Date());
                    signUpInfoMapper.updateByPrimaryKeySelective(signUpInfo);
                    return new ReturnDataAndInfo(false,"该顾问仍在任用中，如需继续，请更改顾问状态。");
                }
                else {
                    UserBindToDemand userBindToDemand = new UserBindToDemand(null,demandId,userId,true,
                            checkerId,new Date(),null);
                    int ret2 = userBindToDemandMapper.insertSelective(userBindToDemand);
                    Project project = projectMapper.selectByPrimaryKey(objectId);
                    if(ret2 > 0){
                        new Thread(()->{
                            String subject = "您（"+username+"）申请的"+demand.getName()+"已通过审核，请联系相关人员"
                                    +project.getManager().getName()+" 邮箱："+project.getManager().getEmail();
                            SimpleMailMessage message = new SimpleMailMessage();
                            message.setFrom(from);
                            message.setTo(registerEmail);
                            message.setSubject(subject);
                            message.setText(content);
                            mailSender.send(message);
                        }).run();
                        Resume resume = new Resume(userId,true);
                        resumeMapper.updateByPrimaryKeySelective(resume);
                        return new ReturnDataAndInfo(true,"");
                    }
                    else {
                        return new ReturnDataAndInfo(false,"操作失败");
                    }
                }
            }
            else {
                return new ReturnDataAndInfo(false,"操作失败");
            }
        }
        else{
            new Thread(()->{
                String subject = "对不起，您（"+username+"）申请的"+demand.getName()+"被驳回";
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom(from);
                message.setTo(registerEmail);
                message.setSubject(subject);
                message.setText(content);
                mailSender.send(message);
            }).run();
            SignUpInfo signUpInfo = new SignUpInfo(userId,demandId,0,null,null,checkerId,new Date());
            int ret1 = signUpInfoMapper.updateByPrimaryKeySelective(signUpInfo);
            if(ret1>0){
                return new ReturnDataAndInfo(true,"");
            }
            else {
                return new ReturnDataAndInfo(false,"操作失败");
            }
        }
    }

    @Override
    public Map<String, Object> getOnePage(Integer pageCode) {
        Map<String,Object> ret = new HashMap<>();
        int total = checkerMapper.count();
        int totalPage = (total-1)/6+1;
        if(pageCode<1) pageCode=1;
        if(pageCode>totalPage) pageCode=totalPage;
        List<Checker> checkers = checkerMapper.selectOnePage((pageCode-1)*6);
        List<CheckerToFront> data = new ArrayList<>(6);
        checkers.forEach(checker -> {
            Client client = clientMapper.selectByPrimaryKey(checker.getClientId());
            CheckerToFront d = new CheckerToFront(
                    null,null,checker.getId(),checker.getLoginName(),
                    checker.getName(),checker.getEmail(),checker.getMobile(),checker.getClientId(),
                    client==null?null:client.getCorporateName()
            );
            data.add(d);
        });
        for(int i = 0; i < data.size(); i++){
            CheckerToFront d = data.get(i);
            d.setKey(i+1+"");
            d.setNumber(i+1+"");
        }
        ret.put("success",true);
        ret.put("data",data);
        ret.put("total",total);
        return ret;
    }
}
