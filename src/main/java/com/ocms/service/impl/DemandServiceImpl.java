package com.ocms.service.impl;

import com.ocms.dao.DemandMapper;
import com.ocms.dao.MessageFromCheckerToManagerMapper;
import com.ocms.dao.ProjectMapper;
import com.ocms.dao.SignUpInfoMapper;
import com.ocms.entities.*;
import com.ocms.service.DemandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DemandServiceImpl implements DemandService {

    @Resource
    private DemandMapper demandMapper;

    @Resource
    private SignUpInfoMapper signUpInfoMapper;

    @Resource
    private MessageFromCheckerToManagerMapper messageFromCheckerToManagerMapper;

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<LatestDemandInfo> getLatest() {
        List<Demand> demands = demandMapper.selectLatestDemand();
        List<LatestDemandInfo> latestDemandInfos = new ArrayList<>(12);
        for (Demand demand :
                demands) {
            LatestDemandInfo latestDemandInfo = new LatestDemandInfo();
            latestDemandInfo.setId(demand.getId());
            if(demand.getProject() == null){
                latestDemandInfo.setProjectName(null);
            }
            else {
                latestDemandInfo.setProjectName(demand.getProject().getName());
                if(demand.getProject().getClient() == null){
                    latestDemandInfo.setCompany(null);
                }
                else {
                    latestDemandInfo.setCompany(demand.getProject().getClient().getCorporateName());
                }
            }
            latestDemandInfo.setJobName(demand.getName());
            if(demand.getPriceFluctuation()==null||demand.getPriceFluctuation()==0)
                latestDemandInfo.setSalary(demand.getPrice().toString());
            else latestDemandInfo.setSalary((demand.getPrice()-demand.getPriceFluctuation())+"-"+(demand.getPrice()+demand.getPriceFluctuation()));
            latestDemandInfo.setPriceUnit(demand.getPriceUnit());
            latestDemandInfos.add(latestDemandInfo);
        }
        return latestDemandInfos;
    }

    @Override
    public DetailDemandInfo getDetail(Long userId, Long demandId) {
        DetailDemandInfo detailDemandInfo = new DetailDemandInfo();
        Demand demand = demandMapper.selectByPrimaryKey(demandId);
        detailDemandInfo.setId(demand.getId());
        detailDemandInfo.setJobName(demand.getName());
        if(demand.getPriceFluctuation()==null||demand.getPriceFluctuation()==0)
            detailDemandInfo.setSalary(demand.getPrice().toString());
        else detailDemandInfo.setSalary((demand.getPrice()-demand.getPriceFluctuation())+"-"+(demand.getPrice()+demand.getPriceFluctuation()));
        detailDemandInfo.setPriceUnit(demand.getPriceUnit());
        detailDemandInfo.setLocation(demand.getWorkAddress());
        detailDemandInfo.setDuration(demand.getDuration());
        detailDemandInfo.setCycle(demand.getCycle());
        detailDemandInfo.setBaozhusu(demand.getBoard());
        SignUpInfo signUpInfo = signUpInfoMapper.selectByPrimaryKey(new SignUpInfoKey(userId,demandId));
        if(signUpInfo == null)
            detailDemandInfo.setSignUp(false);
        else detailDemandInfo.setSignUp(true);
        detailDemandInfo.setNumSignUp(signUpInfoMapper.getNumberOfSignUp(demandId));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        detailDemandInfo.setReleaseTime(format.format(demand.getReleaseTime()));
        if(demand.getProject() == null){
            detailDemandInfo.setProjectName(null);
        }
        else {
            detailDemandInfo.setProjectName(demand.getProject().getName());
            if(demand.getProject().getClient() == null){
                detailDemandInfo.setCompany(null);
            }
            else {
                detailDemandInfo.setCompany(demand.getProject().getClient().getCorporateName());
                detailDemandInfo.setCompanyIntro(demand.getProject().getClient().getIntroduction());
            }
        }
        detailDemandInfo.setDescription(demand.getDescription());
        return detailDemandInfo;
    }

    @Override
    public Map<String, Object> demandListData() {
        Map<String,Object> ret = new HashMap<>(2);
        List<DemandListElement> demandListElements = new ArrayList<>(4);
        List<Demand> demands = demandMapper.selectFourDemand();
        for (Demand demand :
                demands) {
            DemandListElement demandListElement = new DemandListElement();
            demandListElement.setId(demand.getId());
            demandListElement.setJobName(demand.getName());
            if(demand.getPriceFluctuation()==null||demand.getPriceFluctuation()==0)
                demandListElement.setSalary(demand.getPrice().toString());
            else demandListElement.setSalary((demand.getPrice()-demand.getPriceFluctuation())+"-"+(demand.getPrice()+demand.getPriceFluctuation()));
            demandListElement.setLocation(demand.getWorkAddress());
            demandListElement.setPriceUnit(demand.getPriceUnit());
            demandListElement.setBaozhusu(demand.getIsBoard());
            demandListElement.setDuration(demand.getDuration());
            demandListElement.setCycle(demand.getCycle());
            demandListElement.setReleaseTime(new SimpleDateFormat("yyyy-MM-dd").format(demand.getReleaseTime()));
            if(demand.getProject() == null){
                demandListElement.setProjectName(null);
            }
            else {
                demandListElement.setProjectName(demand.getProject().getName());
            }
            demandListElement.setNumSignUp(signUpInfoMapper.getNumberOfSignUp(demand.getId()));
            demandListElements.add(demandListElement);
        }
        ret.put("lists",demandListElements);
        ret.put("totalPages",(demandMapper.countOfSelectAll()-1)/4+1);
        return ret;
    }

    @Override
    public Map<String, Object> demandListDataWithConditions(Integer pageCode, Long employType, String jobExperience, Integer demandDuration, Integer salary) {
        Map<String,Object> ret = new HashMap<>(2);
        List<DemandListElement> demandListElements = new ArrayList<>(4);
        Map<String,Object> conditions = new HashMap<>();
        if(employType !=0 )
            conditions.put("type",employType);
        if(!jobExperience.equals("0"))
            conditions.put("employTime",jobExperience);
        LinkedList<Demand> demands = demandMapper.selectWithConditions(conditions);
        //在迭代器中，不能改变被迭代的对象，否则会出现索引错乱，抛出java.util.ConcurrentModificationException异常
        LinkedList<Demand> removeDemands = new LinkedList<>();
        if(salary == 0){

        }
        else if(salary == 1){
            for (Demand demand :
                    demands) {
                if(demand.getPrice()>500)
                    removeDemands.add(demand);
            }
        }
        else if(salary == 2){
            for (Demand demand :
                    demands) {
                if(demand.getPrice()>1000||demand.getPrice()<500)
                    removeDemands.add(demand);
            }
        }
        else if(salary == 3){
            for (Demand demand :
                    demands) {
                if(demand.getPrice()>1500||demand.getPrice()<1001)
                    removeDemands.add(demand);
            }
        }
        else if(salary == 4){
            for (Demand demand :
                    demands) {
                if(demand.getPrice()>2000||demand.getPrice()<1501)
                    removeDemands.add(demand);
            }
        }
        else if(salary == 5){
            for (Demand demand :
                    demands) {
                if(demand.getPrice()>2500||demand.getPrice()<2001)
                    removeDemands.add(demand);
            }
        }
        else if(salary == 6){
            for (Demand demand :
                    demands) {
                if(demand.getPrice()<2500)
                    removeDemands.add(demand);
            }
        }
        demands.removeAll(removeDemands);
        int totalPages = (demands.size()-1)/4+1;
        if(pageCode > totalPages)
            pageCode = totalPages;
        for(int i = (pageCode-1)*4; i < pageCode*4; i++){
            if(i==demands.size())
                break;
            Demand demand = demands.get(i);

            DemandListElement demandListElement = new DemandListElement();
            demandListElement.setId(demand.getId());
            demandListElement.setJobName(demand.getName());
            if(demand.getPriceFluctuation()==null||demand.getPriceFluctuation()==0)
                demandListElement.setSalary(demand.getPrice().toString());
            else demandListElement.setSalary((demand.getPrice()-demand.getPriceFluctuation())+"-"+(demand.getPrice()+demand.getPriceFluctuation()));
            demandListElement.setLocation(demand.getWorkAddress());
            demandListElement.setPriceUnit(demand.getPriceUnit());
            demandListElement.setBaozhusu(demand.getIsBoard());
            demandListElement.setDuration(demand.getDuration());
            demandListElement.setCycle(demand.getCycle());
            demandListElement.setReleaseTime(new SimpleDateFormat("yyyy-MM-dd").format(demand.getReleaseTime()));
            if(demand.getProject() == null){
                demandListElement.setProjectName(null);
            }
            else {
                demandListElement.setProjectName(demand.getProject().getName());
            }
            demandListElement.setNumSignUp(signUpInfoMapper.getNumberOfSignUp(demand.getId()));
            demandListElements.add(demandListElement);
        }
        ret.put("lists",demandListElements);
        ret.put("totalPages",totalPages);
        return ret;
    }

    @Override
    public ReturnDataAndInfo addDemand(Demand demand) {
        demand.setCreateDate(new Date());
        demand.setExamineStatus(0);
        if(demand.getObjectId() == null){
            return new ReturnDataAndInfo(false,"项目ID为空，无法创建需求！");
        }
        Demand demand1 = demandMapper.selectByNumber(demand.getNumber());
        if(demand1 != null)
        {
            return new ReturnDataAndInfo(false,"编号冲突！");
        }
        int ret = demandMapper.insertSelective(demand);
        if(ret>0)
            return new ReturnDataAndInfo(true,"");
        return new ReturnDataAndInfo(false,"添加需求失败！");
    }

    @Override
    public Map<String, Object> getDemandApplyForChecker(Long checkerId, Integer pageCode) {
        List<Demand> demands = demandMapper.getDemandApplyForChecker(checkerId);
        int total = demands.size();
        int totalPages = (total-1)/6+1;
        if(pageCode>totalPages)
            pageCode = totalPages;
        if(pageCode < 1)
            pageCode = 1;
        List<DemandForChecker> data = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = (pageCode-1)*6; i < pageCode*6; i++){
            if(i == demands.size())
                break;
            Demand demand = demands.get(i);
            String jobYears = demand.getEmployTime();
            if(jobYears.equals("0")){
                jobYears = "不限";
            }
            else if(jobYears.equals("1")){
                jobYears = "应届生";
            }
            else if(jobYears.equals("2")){
                jobYears = "1-3年";
            }
            else if(jobYears.equals("3")){
                jobYears = "4-6年";
            }
            else if(jobYears.equals("4")){
                jobYears="7-10年";
            }
            else if(jobYears.equals("5")){
                jobYears="10年以上";
            }
            DemandForChecker demandForChecker = new DemandForChecker(
                   demand.getId().toString(),demand.getId(),demand.getName(),
                   demand.getNumber(),demand.getExamineStatus()==0?"待审核":demand.getExamineStatus()==1?"已发布":"审核拒绝",
                    demand.getModular(),jobYears,demand.getWorkAddress(),demand.getStartDate()==null?"":sdf.format(demand.getStartDate()),
                    demand.getCycle(),demand.getPrice(),demand.getPriceUnit(),demand.getObjectId());
            data.add(demandForChecker);

        }
        Map<String,Object> ret = new HashMap<>();
        ret.put("success",true);
        ret.put("data",data);
        ret.put("total",total);
        return ret;
    }

    @Override
    public Demand getById(Long id) {
        return demandMapper.selectByPrimaryKey(id);
    }

    @Override
    public ReturnDataAndInfo updateByChecker(MessageFromCheckerToManager messageFromCheckerToManager) {
        Long demandId = messageFromCheckerToManager.getDemandId();
        Demand demand = demandMapper.selectByPrimaryKey(demandId);
        if(!demand.getExamineStatus().equals(0)){
            return new ReturnDataAndInfo(false,"该需求已被审核过了.");
        }
        else {
            Boolean isPassed = messageFromCheckerToManager.getExamineStatus();
            if(isPassed){
                demand.setExamineStatus(1);
                demand.setExamineId(messageFromCheckerToManager.getCheckerId());
                demand.setLastUpdateBy(messageFromCheckerToManager.getCheckerId());
                demand.setLastUpdateDate(new Date());
                demand.setStatus(1);
                int ret1 = demandMapper.updateByPrimaryKeySelective(demand);
                messageFromCheckerToManager.setCreateDate(new Date());
                messageFromCheckerToManager.setIsRead(false);
                Project project = projectMapper.selectByPrimaryKey(demand.getObjectId());
                messageFromCheckerToManager.setManagerId(project.getManagerId());
                int ret2 = messageFromCheckerToManagerMapper.insertSelective(messageFromCheckerToManager);
                if(ret1>0 && ret2>0)
                {
                    return new ReturnDataAndInfo(true,"");
                }
                else {
                    return new ReturnDataAndInfo(false,"审核出错！");
                }
            }
            else {
                demand.setExamineStatus(2);
                demand.setExamineId(messageFromCheckerToManager.getCheckerId());
                demand.setLastUpdateBy(messageFromCheckerToManager.getCheckerId());
                demand.setLastUpdateDate(new Date());
                demand.setStatus(0);
                int ret1 = demandMapper.updateByPrimaryKeySelective(demand);
                messageFromCheckerToManager.setCreateDate(new Date());
                messageFromCheckerToManager.setIsRead(false);
                Project project = projectMapper.selectByPrimaryKey(demand.getObjectId());
                messageFromCheckerToManager.setManagerId(project.getManagerId());
                int ret2 = messageFromCheckerToManagerMapper.insertSelective(messageFromCheckerToManager);
                if(ret1>0 && ret2>0)
                {
                    return new ReturnDataAndInfo(true,"");
                }
                else {
                    return new ReturnDataAndInfo(false,"审核出错！");
                }
            }
        }
    }
}
