package com.ocms.service;

import com.ocms.entities.CommentOnUser;
import com.ocms.entities.ReturnDataAndInfo;

public interface CommentService {
    ReturnDataAndInfo addComment(CommentOnUser commentOnUser);
}
