package com.ocms.service;

import com.ocms.entities.Resume;

import java.util.Map;

public interface ResumeService {
    int addResume(Resume resume);

    Resume getById(Long id);

    Map<String,Object> getOnePageConsultantInfo(Integer pageCode);

    int saveResume(Resume resume);

    int deleteConsultantInfo(Long id);
}
