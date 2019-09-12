package com.ocms.dao;

import com.ocms.entities.MessageFromCheckerToManager;

import java.util.List;

public interface MessageFromCheckerToManagerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MessageFromCheckerToManager record);

    int insertSelective(MessageFromCheckerToManager record);

    MessageFromCheckerToManager selectByPrimaryKey(Long id);

    List<MessageFromCheckerToManager> selectForManager(Long managerId);

    int updateByPrimaryKeySelective(MessageFromCheckerToManager record);

    int updateByPrimaryKey(MessageFromCheckerToManager record);
}