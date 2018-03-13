package com.heqing.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.heqing.entity.orm.Datebase;
import com.heqing.repository.DatebaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.log4j.Logger;

import com.heqing.service.DatebaseService;

/**
 * 数据库连接信息数据持久层实现类
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-03-13 18:06:50
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
    public PageInfo<Datebase> listDatebaseByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Datebase> datebaseList = datebaseRepository.listDatebase();
        return new PageInfo<Datebase>(datebaseList);
    }

    @Override
    public PageInfo<Datebase> listDatebaseByParamAndPage(Datebase datebase, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Datebase> datebaseList = datebaseRepository.listDatebaseByParam(datebase);
        return new PageInfo<Datebase>(datebaseList);
    }

}
