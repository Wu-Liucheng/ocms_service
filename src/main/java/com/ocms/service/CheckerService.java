package com.ocms.service;

import com.ocms.entities.ReturnDataAndInfo;

import java.util.Map;

public interface CheckerService {
    ReturnDataAndInfo verifyIsLegal(String loginName, String password);

    Long getIdByLoginName(String loginName);

    ReturnDataAndInfo checkAction(Boolean isPassed,Long userId,String username,
                                  Long demandId,Long objectId,Long checkerId,
                                  String content);
    Map<String,Object> getOnePage(Integer pageCode);
}
