package com.ocms.service;

import com.ocms.entities.Client;
import com.ocms.entities.ReturnDataAndInfo;

import java.util.Map;

public interface ClientService {

    Map<String,Object> getOnePageClientInfo(Integer pageCode);

    Client getOneClientInfo(Long id);

    Boolean verifyCorporateAdmin(Map map);

    ReturnDataAndInfo save(Client client);

    ReturnDataAndInfo add(Client client);
}
