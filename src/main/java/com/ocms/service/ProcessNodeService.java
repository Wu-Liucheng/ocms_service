package com.ocms.service;

import com.ocms.entities.CorporationAdmin;
import com.ocms.entities.ProcessNode;
import com.ocms.entities.ReturnDataAndInfo;

import java.util.List;
import java.util.Map;

public interface ProcessNodeService {

    Map<String,Object> getOnePageNodeInfo(Integer pageCode);

    List<String> getClientsInfoByAdminName(String loginName);

    List<String> getAllChecker();

    ReturnDataAndInfo addProcessNode(ProcessNode processNode);

    Boolean verifyCorporationAdmin(CorporationAdmin corporationAdmin);

    ReturnDataAndInfo deleteNode(ProcessNode node);
}
