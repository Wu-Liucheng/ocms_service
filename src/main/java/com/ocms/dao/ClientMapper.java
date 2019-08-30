package com.ocms.dao;

import com.ocms.entities.Client;

import java.util.List;
import java.util.Map;

public interface ClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Long id);

    List<Client> selectAll();

    Client selectByCustomerNumber(String customerNumber);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
}