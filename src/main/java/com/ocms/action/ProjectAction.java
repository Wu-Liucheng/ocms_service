package com.ocms.action;

import com.ocms.entities.Project;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectAction {
    @Resource
    private ProjectService projectService;

    @RequestMapping(value = "/get-one-page-projects",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getOnePageProjects(@RequestParam(value = "pageCode") Integer pageCode){
        return projectService.getOnePage(pageCode);
    }

    @RequestMapping(value = "/get-one-page-projects-yourself",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getOnePageAboutHimself(@RequestParam(value = "pageCode") Integer pageCode,
                                                     @RequestParam(value = "username") String username)
    {
        return projectService.getOnePageAboutHimself(pageCode,username);
    }

    @RequestMapping(value = "/get-one-project",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAProjectInfo(@RequestParam(value = "id") Long id){
        return projectService.getAProjectInfo(id);
    }

    @RequestMapping(value = "/verify-project-manager",method = RequestMethod.POST)
    @ResponseBody
    public Boolean verifyProjectIsBelongToHim(@RequestParam(value = "username") String username,
                                              @RequestParam(value = "projectId") Long projectId)
    {
        return projectService.verifyProjectIsBelongToHim(username,projectId);
    }

    @RequestMapping(value = "/update-project",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo updateProject(@RequestBody Project project)
    {
        return projectService.update(project);
    }

    @RequestMapping(value = "/project-get-all-clients",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getAllSimplyClientInfo(){
        return projectService.getSimplyClientInformation();
    }

    @RequestMapping(value = "/project-get-a-clients-managers",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getSimplyManagerInfoByClientId(@RequestParam(value = "clientId") Long clientId)
    {
        return projectService.getSimplyManagerInfoByClientId(clientId);
    }

    @RequestMapping(value = "/project-get-a-manager",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> returnManagerAndClientInfo(@RequestParam(value = "username") String loginName)
    {
        return projectService.getAManagerAndClientInfo(loginName);
    }

    @RequestMapping(value = "/project-add",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo addProject(@RequestBody Project project)
    {
        return projectService.add(project);
    }
}
