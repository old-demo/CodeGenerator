package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.jingye.entity.Feedback;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@Mapper
public interface FeedbackRepository {

    /**
     * 增加实例
     *
     * @param feedback 实例
     * @return int 成功数量
     */
    int saveFeedback(Feedback feedback);

    /**
     * 增加多条
     *
     * @param feedbackList 多条列
     * @return int 成功数量
     */
    int saveBatchFeedback(List<Feedback> feedbackList);

    /**
     * 获取所有
     *
     * @return List<Feedback> 主键集合
     */
    List<Feedback> listFeedback();

    /**
     * 根据条件获取多条
     *
     * @param feedback 列:做条件查询使用
     * @return List<Feedback> 列集合
     */
    List<Feedback> listFeedbackByParam(Feedback feedback);

    /**
     * 根据条件删除多条实例
     *
     * @param feedback 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteFeedbackByParam(Feedback feedback);


    /**
     * 根据主键修改
     *
     * @param feedback 列信息
     * @return int 成功数量
     */
    int updateFeedbackByKey(Feedback feedback);

    /**
     * 根据主键获取
     *
     * @param feedbackId 问题反馈id
     * @return Feedback 信息
     */
    Feedback getFeedbackByKey(@Param("feedbackId")Integer feedbackId);

    /**
     * 根据主键删除
     *
    * @param feedbackId 问题反馈id
     * @return int 成功数量
     */
    int deleteFeedbackByKey(@Param("feedbackId")Integer feedbackId);

    /**
     * 根据多个主键删除多条
     *
     * @param feedbackIdList  列集合
     * @return int 成功数量
     */
    int deleteBatchFeedbackByKey(List<Integer> feedbackIdList);

    /**
     * 根据多个主键获取
     *
     * @param feedbackIdList 列集合
     * @return List<T> 列实体信息
     */
    List<Feedback> listFeedbackByKey(List<Integer> feedbackIdList);

}
