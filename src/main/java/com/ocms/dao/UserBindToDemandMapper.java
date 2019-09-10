package com.ocms.dao;

import com.ocms.entities.UserBindToDemand;

import java.util.List;
import java.util.Map;

public interface UserBindToDemandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserBindToDemand record);

    int insertSelective(UserBindToDemand record);

    UserBindToDemand selectByPrimaryKey(Long id);

    UserBindToDemand findUserIsBeingUsed(Long userId);


    int updateByPrimaryKeySelective(UserBindToDemand record);

    int updateByPrimaryKey(UserBindToDemand record);

    int updateByDemandIdAndUserId(UserBindToDemand record);

    int countOfOneChecker(Long checkerId);

    List<UserBindToDemand> selectForOneChecker(Map map);
}