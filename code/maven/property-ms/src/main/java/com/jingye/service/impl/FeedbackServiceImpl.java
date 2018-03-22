package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.jingye.entity.Feedback;
import com.jingye.repository.FeedbackRepository;
import com.jingye.service.FeedbackService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

    private static final Logger LOGGER = Logger.getLogger(FeedbackServiceImpl.class);

	@Autowired
	private FeedbackRepository feedbackRepository;

    @Override
    public int saveFeedback(Feedback feedback) {
        if(feedback == null) {
            LOGGER.error("--> feedback 不能为null！" );
            return 0;
        }
        if(feedback.getFeedbackTime() == null) {
            LOGGER.error("--> feedback 反馈时间 不能为null！"  + feedback);
            return 0;
        }
        if(feedback.getFeedbackOwnerId() == null) {
            LOGGER.error("--> feedback 业主id 不能为null！"  + feedback);
            return 0;
        }
        return feedbackRepository.saveFeedback(feedback);
    }

    @Override
    public int saveFeedback(List<Feedback> feedbackList) {
        List<Feedback> tempfeedbackList = new ArrayList<>();
        for(Feedback feedback : feedbackList) {
            if(feedback == null) {
                LOGGER.error("--> feedback 不能为null！" );
                continue;
            }
            if(feedback.getFeedbackTime() == null) {
                LOGGER.error("--> feedback 反馈时间 不能为null！"  + feedback);
                continue;
            }
            if(feedback.getFeedbackOwnerId() == null) {
                LOGGER.error("--> feedback 业主id 不能为null！"  + feedback);
                continue;
            }
            tempfeedbackList.add(feedback);
        }
        return feedbackRepository.saveBatchFeedback(tempfeedbackList);
    }

    @Override
    public List<Feedback> listFeedback() {
        return feedbackRepository.listFeedback();
    }

    @Override
    public List<Feedback> listFeedbackByParam(Feedback feedback) {
        return feedbackRepository.listFeedbackByParam(feedback);
    }

    @Override
    public PageInfoUtil<Feedback> listFeedbackByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Feedback> feedbackPage = new PageInfo<Feedback>(feedbackRepository.listFeedback());
        return new PageInfoUtil(feedbackPage.getList(), pageNum, pageSize, feedbackPage.getTotal());
    }

    @Override
    public PageInfoUtil<Feedback> listFeedbackByParamAndPage(Feedback feedback, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Feedback> feedbackPage = new PageInfo<Feedback>(feedbackRepository.listFeedbackByParam(feedback));
        return new PageInfoUtil(feedbackPage.getList(), pageNum, pageSize, feedbackPage.getTotal());
    }

    @Override
    public int deleteFeedbackByParam(Feedback feedback) {
        return feedbackRepository.deleteFeedbackByParam(feedback);
    }

    @Override
    public int updateFeedbackByKey(Feedback feedback) {
        if(feedback == null) {
            LOGGER.error("--> feedback 不能为null！" );
            return 0;
        }
        if(feedback.getFeedbackTime() == null) {
            LOGGER.error("--> feedback 反馈时间 不能为null！"  + feedback);
            return 0;
        }
        if(feedback.getFeedbackOwnerId() == null) {
            LOGGER.error("--> feedback 业主id 不能为null！"  + feedback);
            return 0;
        }
        return feedbackRepository.updateFeedbackByKey(feedback);
    }

    @Override
    public int updateFeedbackByKey(List<Feedback> feedbackList) {
        int successNum = 0;
        for(Feedback feedback : feedbackList) {
            successNum += updateFeedbackByKey(feedback);
        }
        return successNum;
    }


    @Override
    public Feedback getFeedbackByKey(Integer feedbackId) {
        return feedbackRepository.getFeedbackByKey(feedbackId);
    }

    @Override
    public List<Feedback> listFeedbackByKey(List<Integer> feedbackIdList) {
        return feedbackRepository.listFeedbackByKey(feedbackIdList);
    }

    @Override
    public int deleteFeedbackByKey(Integer feedbackId) {
        return feedbackRepository.deleteFeedbackByKey(feedbackId);
    }

    @Override
    public int deleteFeedbackByKey(List<Integer> feedbackIdList) {
        return  feedbackRepository.deleteBatchFeedbackByKey(feedbackIdList);
    }

}
