package com.ocms.dao;

import com.ocms.entities.Checker;

import java.util.List;

public interface CheckerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Checker record);

    int insertSelective(Checker record);

    Checker selectByPrimaryKey(Long id);

    List<Checker> selectAll();

    Checker selectByLoginName(String loginName);

    int count();

    List<Checker> selectOnePage(Integer start);

    int updateByPrimaryKeySelective(Checker record);

    int updateByPrimaryKey(Checker record);
}