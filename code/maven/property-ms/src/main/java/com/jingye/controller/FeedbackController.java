package com.jingye.controller;

import com.jingye.entity.Feedback;
import com.jingye.controller.request.FeedbackRequest;
import com.jingye.service.FeedbackService;
import com.jingye.util.ResponseUtil;
import com.jingye.util.PageInfoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 对外接口层
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value = "/saveFeedback", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        Feedback feedback = feedbackRequest.getFeedback();
        if(feedback == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = feedbackService.saveFeedback(feedback);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateFeedbackByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateFeedbackByKey(@RequestBody FeedbackRequest feedbackRequest) {
        if(feedbackRequest.getFeedbackTime() == null) {
            return new ResponseUtil(0, "反馈时间不能为null！", null);
        }
        if(feedbackRequest.getFeedbackOwnerId() == null) {
            return new ResponseUtil(0, "业主id不能为null！", null);
        }
        Feedback feedback = feedbackRequest.getFeedback();
        if(feedback == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = feedbackService.updateFeedbackByKey(feedback);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteFeedbackByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteFeedbackByKey(@RequestBody FeedbackRequest feedbackRequest) {
        if(feedbackRequest.getFeedbackId() == null) {
            return new ResponseUtil(0, "问题反馈id不能为null！", null);
        }
        int result = feedbackService.deleteFeedbackByKey(feedbackRequest.getFeedbackId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchFeedbackByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchFeedbackByKey(@RequestBody FeedbackRequest feedbackRequest) {
        List<Integer> feedbackIds = feedbackRequest.getFeedbackIdList();
        if(feedbackIds == null || feedbackIds.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = feedbackService.deleteFeedbackByKey(feedbackIds);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getFeedbackByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getFeedbackByKey(@RequestBody FeedbackRequest feedbackRequest) {
        if(feedbackRequest.getFeedbackId() == null) {
            return new ResponseUtil(0, "问题反馈id不能为null！", null);
        }
        Feedback feedback = feedbackService.getFeedbackByKey(feedbackRequest.getFeedbackId());
        return new ResponseUtil(1, "OK", feedback);
    }

    @RequestMapping(value = "/listFeedbackByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listFeedbackByParamAndPage(@RequestBody FeedbackRequest feedbackRequest) {
        int pageNum = 1, pageSize = 100;
        if(feedbackRequest.getPageNum() != 0) {
            pageNum = feedbackRequest.getPageNum();
        }
        if(feedbackRequest.getPageSize() != 0) {
            pageSize = feedbackRequest.getPageSize();
        }
        Feedback feedback = feedbackRequest.getFeedback();
        if(feedback == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<Feedback> feedbackList = feedbackService.listFeedbackByParamAndPage(feedback, pageNum, pageSize);
        return new ResponseUtil(1, "OK", feedbackList);
    }

}
