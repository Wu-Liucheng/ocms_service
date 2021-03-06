package com.ocms.dao;

import com.ocms.entities.Manager;

import java.util.List;

public interface ManagerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Long id);

    Manager selectByLoginName(String loginName);

    Manager selectByEmail(String email);

    int updateByPrimaryKeySelective(Manager record);

    List<Manager> selectByClientId(Long clientId);

    int count();

    List<Manager> selectOnePage(Integer start);

    int updateByPrimaryKey(Manager record);
}