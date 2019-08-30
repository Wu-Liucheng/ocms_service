package com.ocms.dao;

import com.ocms.entities.Administrator;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Long id);

    Administrator selectByLoginName(String loginName);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);
}