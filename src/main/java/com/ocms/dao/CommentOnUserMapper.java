package com.ocms.dao;

import com.ocms.entities.CommentOnUser;

import java.util.List;

public interface CommentOnUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentOnUser record);

    int insertSelective(CommentOnUser record);

    CommentOnUser selectByPrimaryKey(Long id);

    List<CommentOnUser> getCommentOnAUser(Long userId);

    int updateByPrimaryKeySelective(CommentOnUser record);

    int updateByPrimaryKey(CommentOnUser record);
}