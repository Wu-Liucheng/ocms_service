package com.ocms.dao;

import com.ocms.entities.CheckEmail;

import java.util.Map;

public interface CheckEmailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CheckEmail record);

    int insertSelective(CheckEmail record);

    CheckEmail selectByPrimaryKey(Long id);

    CheckEmail selectByEmailAndCode(Map map);

    int updateByPrimaryKeySelective(CheckEmail record);

    int updateByPrimaryKey(CheckEmail record);
}