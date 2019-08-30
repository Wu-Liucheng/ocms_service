package com.ocms.service.impl;

import com.ocms.dao.ClientMapper;
import com.ocms.dao.ManagerMapper;
import com.ocms.dao.ProjectMapper;
import com.ocms.entities.*;
import com.ocms.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Resource
    private ClientMapper clientMapper;

    @Resource
    private ManagerMapper managerMapper;

    @Override
    public Map<String, Object> getOnePage(Integer pageCode) {
        int total = projectMapper.count();
        int totalPage = (total-1)/6+1;
        if(pageCode<1) pageCode = 1;
        if(pageCode>totalPage) pageCode = totalPage;
        List<Project> projects = projectMapper.selectOnePage((pageCode-1)*6);
        List<ProjectInfoReturnToFront> data = new ArrayList<>(6);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        projects.forEach((project)->{
            ProjectInfoReturnToFront info = new ProjectInfoReturnToFront(
                    project.getId().toString(),
                    project.getId(),project.getNumber(),project.getName(),
                    project.getManager()==null?null:project.getManager().getName(),
                    project.getStatus()==1?"Open":"Close",
                    project.getStartDate()==null?null:sdf.format(project.getStartDate()),
                    project.getEndDate()==null?null:sdf.format(project.getEndDate()),
                    project.getClient()==null?null:project.getClient().getCorporateName()
            );
            data.add(info);
        });
        Map<String,Object> ret = new HashMap<>(3);
        ret.put("success",true);
        ret.put("projects",data);
        ret.put("total",total);
        return ret;
    }

    @Override
    public Map<String, Object> getOnePageAboutHimself(Integer pageCode, String username) {
        Manager manager = managerMapper.selectByLoginName(username);

        int total = projectMapper.countAboutOneManager(manager.getId());
        int totalPage = (total-1)/6+1;
        if(pageCode<1) pageCode = 1;
        if(pageCode>totalPage) pageCode = totalPage;
        Map<String,Object> param = new HashMap<>();
        param.put("start",(pageCode-1)*6);
        param.put("managerId",manager.getId());
        List<Project> projects = projectMapper.selectOnePageAboutHim(param);
        List<ProjectInfoReturnToFront> data = new ArrayList<>(6);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        projects.forEach((project)->{
            ProjectInfoReturnToFront info = new ProjectInfoReturnToFront(
                    project.getId().toString(),
                    project.getId(),project.getNumber(),project.getName(),
                    project.getManager()==null?null:project.getManager().getName(),
                    project.getStatus()==1?"Open":"Close",
                    project.getStartDate()==null?null:sdf.format(project.getStartDate()),
                    project.getEndDate()==null?null:sdf.format(project.getEndDate()),
                    project.getClient()==null?null:project.getClient().getCorporateName()
            );
            data.add(info);
        });
        Map<String,Object> ret = new HashMap<>(3);
        ret.put("success",true);
        ret.put("projects",data);
        ret.put("total",total);
        return ret;
    }

    @Override
    public Map<String, Object> getAProjectInfo(Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Project project = projectMapper.selectByPrimaryKey(id);
        Map<String,Object> ret = new HashMap<>();
        ret.put("id",project.getId());
        ret.put("name",project.getName());
        ret.put("number",project.getNumber());
        ret.put("status",project.getStatus());
        ret.put("startDate",project.getStartDate()==null?"":sdf.format(project.getStartDate()));
        ret.put("endDate",project.getEndDate()==null?"":sdf.format(project.getEndDate()));
//        Map<String,Object> owner = new HashMap<>();
//        Client client = project.getClient();
//        Manager manager = project.getManager();
//        List<Map<String,Object>> owners = new ArrayList<>();
//        owner.put("value",client.getId());
//        owner.put("label",client.getCorporateName());
//        List<Map<String,Object>> children = new ArrayList<>();
//        Map<String,Object> child = new HashMap<>();
//        child.put("value",manager.getId());
//        child.put("label",manager.getName());
//        children.add(child);
//        owner.put("children",children);
//        owners.add(owner);
//        ret.put("owner",owners);
        Client client = project.getClient();
        Manager manager = project.getManager();
        List<String> clientInfo = new ArrayList<>(1);
        clientInfo.add(client.getId()+":"+client.getCorporateName());
        ret.put("corporateInfo",clientInfo);
        List<String> m = new ArrayList<>(1);
        m.add(manager.getId()+":"+manager.getName());
        ret.put("managerInfo",m);
        return ret;
    }

    @Override
    public Boolean verifyProjectIsBelongToHim(String username, Long projectId) {
        Project project = projectMapper.selectByPrimaryKey(projectId);
        if(project.getManager()!=null&&project.getManager().getLoginName().equalsIgnoreCase(username))
            return true;
        return false;
    }

    @Override
    public ReturnDataAndInfo update(Project project) {
        Project project1 = projectMapper.selectByNumber(project.getNumber());
        if(project1==null||project1.getId().equals(project.getId()))
        {
            int ret = projectMapper.updateByPrimaryKeySelective(project);
            if(ret > 0)
                return new ReturnDataAndInfo(true,"");
            return new ReturnDataAndInfo(false,"修改失败！");
        }
        else
        {
            return new ReturnDataAndInfo(false,"项目编号冲突！");
        }
    }

    @Override
    public List<String> getSimplyClientInformation() {
        List<String> ret = new ArrayList<>();
        List<Client> clients = clientMapper.selectAll();
        clients.forEach((Client client) -> {
            ret.add(client.getId()+":"+client.getCorporateName());
        });
        return ret;
    }

    @Override
    public List<String> getSimplyManagerInfoByClientId(Long clientId) {
        List<Manager> managers = managerMapper.selectByClientId(clientId);
        List<String> ret = new ArrayList<>();
        managers.forEach((Manager manager)->{
            ret.add(manager.getId()+":"+manager.getName());
        });
        return ret;
    }

    @Override
    public Map<String, Object> getAManagerAndClientInfo(String loginName) {
        Map<String,Object> ret = new HashMap<>(2);
        List<String> clientInfo = new ArrayList<>(1);
        List<String> managerInfo = new ArrayList<>(1);
        Manager manager = managerMapper.selectByLoginName(loginName);
        if(manager == null)
        {

        }
        else
        {
            managerInfo.add(manager.getId()+":"+manager.getName());
            Client client = clientMapper.selectByPrimaryKey(manager.getId());
            if(client == null){}
            else {
                clientInfo.add(client.getId()+":"+client.getCorporateName());
            }
        }
        ret.put("clientInfo",clientInfo);
        ret.put("managerInfo",managerInfo);
        return ret;
    }

    @Override
    public ReturnDataAndInfo add(Project project) {
        String number = project.getNumber();
        Project project1 = projectMapper.selectByNumber(number);
        if(project1==null)
        {
            project.setCreateDate(new Date());
            int ret = projectMapper.insertSelective(project);
            if(ret>0)
                return new ReturnDataAndInfo(true,"");
            return new ReturnDataAndInfo(false,"添加失败！");
        }
        else {
            return new ReturnDataAndInfo(false,"项目编号冲突！");
        }
    }
}
