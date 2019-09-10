package com.ocms.action;

import com.ocms.entities.CommentOnUser;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class CommentOnUserAction {

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "/add-comment",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo add(@RequestBody CommentOnUser commentOnUser){
        return commentService.addComment(commentOnUser);
    }
}
