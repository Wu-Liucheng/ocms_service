package com.ocms.dao;

import com.ocms.entities.CorporationAdmin;

import java.util.Map;

public interface CorporationAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CorporationAdmin record);

    int insertSelective(CorporationAdmin record);

    CorporationAdmin selectByPrimaryKey(Long id);

    CorporationAdmin selectByLoginName(String loginName);

    CorporationAdmin selectByLoginNameAndClientId(Map map);

    int updateByPrimaryKeySelective(CorporationAdmin record);

    int updateByPrimaryKey(CorporationAdmin record);
}