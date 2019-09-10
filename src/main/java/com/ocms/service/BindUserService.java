package com.ocms.service;

import java.util.Map;

public interface BindUserService {

    Map<String,Object> getBindUserForManager(Long managerId,Integer pageCode);
}
