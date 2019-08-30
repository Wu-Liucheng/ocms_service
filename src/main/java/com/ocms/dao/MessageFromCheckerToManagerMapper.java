package com.ocms.dao;

import com.ocms.entities.MessageFromCheckerToManager;

public interface MessageFromCheckerToManagerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MessageFromCheckerToManager record);

    int insertSelective(MessageFromCheckerToManager record);

    MessageFromCheckerToManager selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageFromCheckerToManager record);

    int updateByPrimaryKey(MessageFromCheckerToManager record);
}