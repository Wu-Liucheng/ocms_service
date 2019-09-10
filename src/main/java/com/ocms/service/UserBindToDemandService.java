package com.ocms.service;

import com.ocms.entities.Resume;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.entities.UserBindToDemand;

import java.util.Map;

public interface UserBindToDemandService {

    Map<String,Object> getUserStatusForChecker(Long checkerId,Integer pageCode);

    Map<String,Object> getStatus(Long resumeId);

    ReturnDataAndInfo updateConsultantStatus(Resume resume);

    ReturnDataAndInfo relationIsOver(UserBindToDemand userBindToDemand);
}
