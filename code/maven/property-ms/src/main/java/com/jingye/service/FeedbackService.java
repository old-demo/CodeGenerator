package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.Feedback;

import java.util.List;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
public interface FeedbackService {

    /**
     * 增加实例
     *
     * @param feedback 实例
     * @return int 成功数量
     */
    int saveFeedback(Feedback feedback);

    /**
     * 增加多条实例
     *
     * @param feedbackList 多条实例
     * @return int 成功数量
     */
    int saveFeedback(List<Feedback> feedbackList);

    /**
     * 获取所有实例信息
     *
     * @return List<Feedback> 主键集合
     */
    List<Feedback> listFeedback();

    /**
     * 根据条件获取多条实例
     *
     * @param feedback 实例:做条件查询使用
     * @return List<Feedback> 实例集合
     */
    List<Feedback> listFeedbackByParam(Feedback feedback);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Feedback> 实例集合
     */
    PageInfoUtil<Feedback> listFeedbackByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param feedback 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Feedback> 实例集合
     */
    PageInfoUtil<Feedback> listFeedbackByParamAndPage(Feedback feedback, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param feedback 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteFeedbackByParam(Feedback feedback);

    /**
     * 修改实例
     *
     * @param feedback 实例信息
     * @return int 成功数量
     */
    int updateFeedbackByKey(Feedback feedback);

    /**
     * 批量修改实例
     *
     * @param feedbackList 多条实例信息
     * @return int 是否成功
     */
    int updateFeedbackByKey(List<Feedback> feedbackList);


    /**
     * 根据主键获取实例信息
     *
     * @param feedbackId  实例
     * @return List<T> 实例信息
     */
    Feedback getFeedbackByKey(Integer feedbackId);

    /**
     * 根据多个主键获取实例信息
     *
     * @param feedbackIdList  实例集合
     * @return List<T> 实例信息
     */
    List<Feedback> listFeedbackByKey(List<Integer> feedbackIdList);

    /**
     * 根据主键删除多条实例
     *
     * @param feedbackId 主键
     * @return int 成功数量
     */
    int deleteFeedbackByKey(Integer feedbackId);

    /**
     * 根据多个主键删除多条实例
     *
     * @param feedbackIdList 主键集合
     * @return int 成功数量
     */
    int deleteFeedbackByKey(List<Integer> feedbackIdList);

}
