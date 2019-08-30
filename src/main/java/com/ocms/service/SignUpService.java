package com.ocms.service;

import com.ocms.entities.SignUpInfo;

import java.util.Map;

public interface SignUpService {
    int newSignUp(SignUpInfo signUpInfo);

    Map<String,Object> getSignedDemands(Long userId);

    Map<String,Object> getSignedDemands(Long userId,Integer pageCode);
}
