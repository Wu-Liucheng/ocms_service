package com.ocms.service.impl;

import com.ocms.dao.ResumeMapper;
import com.ocms.dao.UserInfoMapper;
import com.ocms.entities.Consultant;
import com.ocms.entities.Resume;
import com.ocms.service.ResumeService;
import com.ocms.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Resource
    ResumeMapper resumeMapper;

    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public int addResume(Resume resume) {
        return resumeMapper.insert(resume);
    }

    @Override
    public Resume getById(Long id) {
        return resumeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveResume(Resume resume) {
        return resumeMapper.updateByPrimaryKeySelective(resume);
    }

    @Override
    public Map<String, Object> getOnePageConsultantInfo(Integer pageCode) {
        List<Resume> resumes = resumeMapper.selectAll();
        Integer total = resumes.size();
        if(pageCode > (total-1)/6+1)
            pageCode = (total-1)/6+1;
        List<Consultant> consultants = new ArrayList<>(6);
        for(int i = (pageCode-1)*6; i < pageCode*6; i++){
            if(i==resumes.size())
                break;
            Resume resume = resumes.get(i);
            consultants.add(new Consultant(String.valueOf(i),resume.getId(),resume.getName(),resume.getGoodAt(),
                    resume.getMobile(),resume.getEmployYears(),resume.getEmail(),resume.getEstimateLevel(),
                    resume.getEmployNumber(),new SimpleDateFormat("yyyy-MM-dd").format(resume.getPlanDate())
                    ,resume.getSex()?"男":"女",resume.getDegree()));
        }
        Map<String,Object> res = new HashMap<>(3);
        res.put("consultants",consultants);
        res.put("total",total);
        res.put("success",true);
        return res;
    }

    @Override
    public int deleteConsultantInfo(Long id) {
        int res1 = resumeMapper.deleteByPrimaryKey(id);
        int res2 = userInfoMapper.deleteByPrimaryKey(id);
        return res1+res2;
    }
}
