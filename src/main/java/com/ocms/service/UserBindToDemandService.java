package com.ocms.service;

import java.util.Map;

public interface UserBindToDemandService {

    Map<String,Object> getUserStatusForChecker(Long checkerId,Integer pageCode);
}
