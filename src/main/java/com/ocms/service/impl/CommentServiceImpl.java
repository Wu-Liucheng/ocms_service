package com.ocms.service.impl;

import com.ocms.dao.CommentOnUserMapper;
import com.ocms.dao.ManagerMapper;
import com.ocms.entities.CommentOnUser;
import com.ocms.entities.Manager;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentOnUserMapper commentOnUserMapper;

    @Resource
    private ManagerMapper managerMapper;

    @Override
    public ReturnDataAndInfo addComment(CommentOnUser commentOnUser) {
        Long managerId = commentOnUser.getManagerId();
        Manager manager = managerMapper.selectByPrimaryKey(managerId);
        if(manager == null){
            return new ReturnDataAndInfo(false,"非法操作！");
        }
        else {
            commentOnUser.setClientId(manager.getClientId());
        }
        commentOnUser.setCreateDate(new Date());
        int r = commentOnUserMapper.insertSelective(commentOnUser);
        if(r>0){
            return new ReturnDataAndInfo(true,"");
        }
        else
        {
            return new ReturnDataAndInfo(false,"添加失败！");
        }
    }
}
