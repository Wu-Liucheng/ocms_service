package com.ocms.dao;

import com.ocms.entities.CorporationAdmin;

import java.util.List;
import java.util.Map;

public interface CorporationAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CorporationAdmin record);

    int insertSelective(CorporationAdmin record);

    CorporationAdmin selectByPrimaryKey(Long id);

    CorporationAdmin selectByLoginName(String loginName);

    CorporationAdmin selectByLoginNameAndClientId(Map map);

    CorporationAdmin selectByEmail(String email);

    int count();

    List<CorporationAdmin> selectOnePage(Integer start);

    int updateByPrimaryKeySelective(CorporationAdmin record);

    int updateByPrimaryKey(CorporationAdmin record);
}