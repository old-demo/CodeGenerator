package com.heqing.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.heqing.entity.orm.Datebase;
import com.heqing.repository.DatebaseRepository;
import com.heqing.util.PageInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.log4j.Logger;

import com.heqing.service.DatebaseService;

/**
 * 数据库连接信息业务逻辑实现类
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-03-18 21:57:48
 */
@Service("datebaseService")
public class DatebaseServiceImpl implements DatebaseService {

    private static final Logger LOGGER = Logger.getLogger(DatebaseServiceImpl.class);

    @Autowired
    private DatebaseRepository datebaseRepository;

    @Override
    public int saveDatebase(Datebase datebase) {
        return datebaseRepository.saveDatebase(datebase);
    }

    @Override
    public int saveBatchDatebase(List<Datebase> datebaseList) {
        return datebaseRepository.saveBatchDatebase(datebaseList);
    }

    @Override
    public int deleteDatebaseByKey(Integer id) {
        return datebaseRepository.deleteDatebaseByKey(id);
    }

    @Override
    public int deleteBatchDatebaseByKey(List<Integer> ids) {
        return datebaseRepository.deleteBatchDatebaseByKey(ids);
    }

    @Override
    public int deleteBatchDatebaseByParam(Datebase datebase) {
        return datebaseRepository.deleteBatchDatebaseByParam(datebase);
    }

    @Override
    public int updateDatebaseByKey(Datebase datebase) {
        return datebaseRepository.updateDatebaseByKey(datebase);
    }

    @Override
    public int updateBatchDatebaseByKey(List<Datebase> datebaseList) {
        return datebaseRepository.updateBatchDatebaseByKey(datebaseList);
    }

    @Override
    public Datebase getDatebaseByKey(Integer id) {
        return datebaseRepository.getDatebaseByKey(id);
    }

    @Override
    public List<Datebase> listDatebaseByKey(List<Integer> ids) {
        return datebaseRepository.listDatebaseByKey(ids);
    }

    @Override
    public List<Datebase> listDatebase() {
        return datebaseRepository.listDatebase();
    }

    @Override
    public List<Datebase> listDatebaseByParam(Datebase datebase) {
        return datebaseRepository.listDatebaseByParam(datebase);
    }

    @Override
    public PageInfoUtil<Datebase> listDatebaseByPage(int pageNo, int pageSize) {
        pageNo = pageNo < 0 ? 0 : pageNo;
        pageSize = pageSize < 1 ? 1 : pageNo > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Datebase> datebasePage = new PageInfo<Datebase>(datebaseRepository.listDatebase());
        return new PageInfoUtil(datebasePage.getList(), pageNo, pageSize, datebasePage.getTotal());
    }

    @Override
    public PageInfoUtil<Datebase> listDatebaseByParamAndPage(Datebase datebase, int pageNum, int pageSize) {
        pageNum = pageNum < 0 ? 0 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Datebase> datebasePage = new PageInfo<Datebase>(datebaseRepository.listDatebaseByParam(datebase));
        return new PageInfoUtil(datebasePage.getList(), pageNum, pageSize, datebasePage.getTotal());
    }
}
