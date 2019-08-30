package com.ocms.dao;

import com.ocms.entities.Resume;

import java.util.ArrayList;

public interface ResumeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resume record);

    int insertSelective(Resume record);

    Resume selectByPrimaryKey(Long id);

    ArrayList<Resume> selectAll();

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);
}