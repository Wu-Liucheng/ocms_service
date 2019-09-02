package com.ocms.dao;

import com.ocms.entities.SignUpInfo;
import com.ocms.entities.SignUpInfoKey;

import java.util.List;

public interface SignUpInfoMapper {
    int deleteByPrimaryKey(SignUpInfoKey key);

    int insert(SignUpInfo record);

    int insertSelective(SignUpInfo record);

    SignUpInfo selectByPrimaryKey(SignUpInfoKey key);

    List<SignUpInfo> selectByUserId(Long userId);

    List<SignUpInfo> selectForChecker(Long checkerId);

    int getNumberOfSignUp(Long demandId);

    int updateByPrimaryKeySelective(SignUpInfo record);

    int updateByPrimaryKey(SignUpInfo record);
}