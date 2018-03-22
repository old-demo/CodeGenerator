package com.jingye.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.jingye.util.PageInfoUtil;

import com.jingye.entity.Feedback;
import com.jingye.service.FeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration(locations = {"classpath*:spring_core.xml","classpath:spring_mybatis.xml"})
public class FeedbackTest {

    @Autowired
    FeedbackService feedbackService;

    @Test
    public void testSaveFeedback() {
        Feedback feedback = new Feedback();
        feedback.setFeedbackTime(new Date());
        feedback.setFeedbackId(1);
        feedback.setFeedbackOwnerId(1);
        feedback.setFeedbackInfo(""+1);
        feedback.setFeedbackNote(""+1);
        System.out.println("-->"+feedbackService.saveFeedback(feedback));
    }

    @Test
    public void testBatchSaveFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            Feedback feedback = new Feedback();
            feedback.setFeedbackTime(new Date());
            feedback.setFeedbackId(i);
            feedback.setFeedbackOwnerId(i);
            feedback.setFeedbackInfo(""+i);
            feedback.setFeedbackNote(""+i);
            feedbackList.add(feedback);
        }
        System.out.println("-->"+feedbackService.saveFeedback(feedbackList));
    }

    @Test
    public void testListFeedback() {
        System.out.println("-->"+feedbackService.listFeedback());
    }

    @Test
    public void testListFeedbackByParam() {
        Feedback feedback = new Feedback();
        feedback.setFeedbackOwnerId(1);
        System.out.println("-->"+feedbackService.listFeedbackByParam(feedback));
    }

    @Test
    public void testListFeedbackByPage() {
        PageInfoUtil<Feedback> feedbackList = feedbackService.listFeedbackByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(feedbackList));
    }

    @Test
    public void testListFeedbackByParamAndPage() {
        Feedback feedback = new Feedback();
        feedback.setFeedbackOwnerId(1);
        PageInfoUtil<Feedback> feedbackList = feedbackService.listFeedbackByParamAndPage(feedback, 1, 2);
        System.out.println("-->"+JSON.toJSONString(feedbackList));
    }

    @Test
    public void testDeleteFeedbackByParam() {
        Feedback feedback = new Feedback();
        feedback.setFeedbackOwnerId(1);
        System.out.println("-->"+feedbackService.deleteFeedbackByParam(feedback));
    }

    @Test
    public void testUpdateFeedbackByKey() {
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(1);
        feedback.setFeedbackOwnerId(1);
        feedback.setFeedbackInfo("1");
        feedback.setFeedbackTime(new Date());
        feedback.setFeedbackNote("1");
        System.out.println("-->"+feedbackService.updateFeedbackByKey(feedback));
    }

    @Test
    public void testUpdateBatchFeedbackByKey() {
        List<Feedback> feedbackList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            Feedback feedback = new Feedback();
            feedback.setFeedbackId(i-5);
            feedback.setFeedbackOwnerId(i);
            feedback.setFeedbackInfo(""+i);
            feedback.setFeedbackTime(new Date());
            feedback.setFeedbackNote(""+i);
            feedbackList.add(feedback);
        }
        System.out.println("-->"+feedbackService.updateFeedbackByKey(feedbackList));
    }


    @Test
    public void testGetFeedbackByKey() {
        int feedbackPK = 1;
        System.out.println("-->"+feedbackService.getFeedbackByKey(feedbackPK));
    }

    @Test
    public void testListFeedbackByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+feedbackService.listFeedbackByKey(keyList));
    }

    @Test
    public void testDeleteFeedbackByKey() {
        int feedbackPK = 1;
        System.out.println("-->"+feedbackService.deleteFeedbackByKey(feedbackPK));
    }

    @Test
    public void testDeleteBatchFeedbackByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+feedbackService.deleteFeedbackByKey(keyList));
    }

}
