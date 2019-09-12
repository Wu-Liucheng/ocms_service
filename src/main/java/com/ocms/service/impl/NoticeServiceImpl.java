package com.ocms.service.impl;

import com.ocms.dao.MessageFromCheckerToManagerMapper;
import com.ocms.entities.MessageFromCheckerToManager;
import com.ocms.entities.MessageToManager;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {


    @Resource
    private MessageFromCheckerToManagerMapper messageFromCheckerToManagerMapper;

    @Override
    public Map<String, Object> getNoticeForManager(Long managerId, Integer pageCode) {
        List<MessageFromCheckerToManager> list = messageFromCheckerToManagerMapper.selectForManager(managerId);
        int total = list.size();
        int totalPages = (total-1)/6+1;
        if(pageCode > totalPages) pageCode = totalPages;
        if(pageCode < 1) pageCode = 1;
        List<MessageToManager> data = new ArrayList<>(6);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = (pageCode - 1) * 6; i < pageCode * 6; i++){
            if(i == total)
                break;
            MessageFromCheckerToManager a=list.get(i);
            MessageToManager m = new MessageToManager(i%6+1+"",i%6+1+"",a.getId(),
                    a.getDemandId(),a.getCheckerId(),a.getContent(),a.getIsRead(),a.getExamineStatus(),
                    sdf.format(a.getCreateDate()),a.getDemand().getName(),a.getChecker().getName());
            data.add(m);
        }
        Map<String,Object> ret = new HashMap<>();
        ret.put("success",true);
        ret.put("data",data);
        ret.put("total",total);
        return ret;
    }

    @Override
    public void setReadStatus(Long id) {
        MessageFromCheckerToManager m = new MessageFromCheckerToManager();
        m.setId(id);
        m.setIsRead(true);
        messageFromCheckerToManagerMapper.updateByPrimaryKeySelective(m);
    }

    @Override
    public ReturnDataAndInfo delete(Long id) {
        int ret = messageFromCheckerToManagerMapper.deleteByPrimaryKey(id);
        if(ret>0)
            return new ReturnDataAndInfo(true,"");
        else
            return new ReturnDataAndInfo(false,"发生了错误!");
    }

    @Override
    public MessageToManager detail(Long id) {
        MessageFromCheckerToManager a = messageFromCheckerToManagerMapper.selectByPrimaryKey(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MessageToManager m = new MessageToManager(null,null,a.getId(),
                a.getDemandId(),a.getCheckerId(),a.getContent(),a.getIsRead(),a.getExamineStatus(),
                sdf.format(a.getCreateDate()),a.getDemand().getName(),a.getChecker().getName());
        return m;
    }
}
