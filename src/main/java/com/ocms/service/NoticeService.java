package com.ocms.service;

import com.ocms.entities.MessageToManager;
import com.ocms.entities.ReturnDataAndInfo;

import java.util.Map;

public interface NoticeService {

    Map<String,Object> getNoticeForManager(Long managerId,Integer pageCode);

    void setReadStatus(Long id);

    ReturnDataAndInfo delete(Long id);

    MessageToManager detail(Long id);
}
