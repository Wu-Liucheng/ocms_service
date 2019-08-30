package com.ocms.dao;

import com.ocms.entities.ProcessNode;

import java.util.List;

public interface ProcessNodeMapper {
    int deleteByPrimaryKey(Long id);

    int deleteSelective(ProcessNode record);

    int insert(ProcessNode record);

    int insertSelective(ProcessNode record);

    ProcessNode selectByPrimaryKey(Long id);

    int count();

    List<ProcessNode> selectOnePage(Integer start);
    List<ProcessNode> selectSelective(ProcessNode record);

    int updateByPrimaryKeySelective(ProcessNode record);

    int updateByPrimaryKey(ProcessNode record);
}