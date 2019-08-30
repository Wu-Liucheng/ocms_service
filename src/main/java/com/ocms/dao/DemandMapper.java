package com.ocms.dao;

import com.ocms.entities.Demand;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface DemandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Demand record);

    int insertSelective(Demand record);

    Demand selectByPrimaryKey(Long id);

    List<Demand> selectLatestDemand();

    List<Demand> selectFourDemand();

    LinkedList<Demand> selectWithConditions(Map map);

    int countOfSelectAll();

    int updateByPrimaryKeySelective(Demand record);

    int updateByPrimaryKey(Demand record);

    Demand selectByNumber(String number);

    List<Demand> getDemandApplyForChecker(Long checkerId);
}