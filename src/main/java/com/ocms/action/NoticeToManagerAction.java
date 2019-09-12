package com.ocms.action;

import com.ocms.entities.MessageToManager;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@Controller
public class NoticeToManagerAction {

    @Resource
    private NoticeService noticeService;


    @RequestMapping(value = "/get-notice",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getNoticeForManager(@RequestParam(value = "managerId") Long managerId,
                                                  @RequestParam(value = "pageCode") Integer pageCode){
        return noticeService.getNoticeForManager(managerId, pageCode);
    }

    @RequestMapping(value = "/set-read-status",method = RequestMethod.POST)
    @ResponseBody
    public void setIsRead(@RequestParam(value = "id")Long id){
        noticeService.setReadStatus(id);
    }

    @RequestMapping(value = "/delete-notice",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo deleteNotice(@RequestParam(value = "id") Long id){
        return noticeService.delete(id);
    }

    @RequestMapping(value = "/detail-notice",method = RequestMethod.GET)
    @ResponseBody
    public MessageToManager detail(@RequestParam(value = "noticeId") Long id){
        return noticeService.detail(id);
    }
}
