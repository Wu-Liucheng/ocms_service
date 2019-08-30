package com.ocms.service;

import com.ocms.entities.Project;
import com.ocms.entities.ReturnDataAndInfo;

import java.util.List;
import java.util.Map;

public interface ProjectService {

    Map<String,Object> getOnePage(Integer pageCode);

    Map<String,Object> getOnePageAboutHimself(Integer pageCode,String username);

    Map<String,Object> getAProjectInfo(Long id);

    Boolean verifyProjectIsBelongToHim(String username, Long projectId);

    ReturnDataAndInfo update(Project project);

    List<String> getSimplyClientInformation();

    List<String> getSimplyManagerInfoByClientId(Long clientId);

    Map<String,Object> getAManagerAndClientInfo(String loginName);

    ReturnDataAndInfo add(Project project);
}
