package com.ocms.dao;

import com.ocms.entities.Project;

import java.util.List;
import java.util.Map;

public interface ProjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Long id);

    Project selectByNumber(String number);

    List<Project> selectOnePage(Integer start);

    List<Project> selectOnePageAboutHim(Map map);

    int count();

    int countAboutOneManager(Long managerId);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}