package com.heqing.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.heqing.entity.orm.DatebaseEntity;
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
 * @date   2018-02-02 09:20:35
 */
@Service("datebaseService")
public class DatebaseServiceImpl implements DatebaseService {

    private static final Logger LOGGER = Logger.getLogger(DatebaseServiceImpl.class);

	@Autowired
	private DatebaseRepository datebaseRepository;

    @Override
    public int saveDatebase(DatebaseEntity datebase) {
        return datebaseRepository.saveDatebase(datebase);
	}

    @Override
    public int saveBatchDatebase(List<DatebaseEntity> datebaseList) {
        return datebaseRepository.saveBatchDatebase(datebaseList);
	}

    @Override
    public int removeDatebaseByKey(Integer id) {
        return datebaseRepository.deleteDatebaseByKey(id);
	}

    @Override
    public int removeBatchDatebaseByKey(List<Integer> ids) {
        return datebaseRepository.deleteBatchDatebaseByKey(ids);
	}

    @Override
    public int removeBatchDatebaseByParam(DatebaseEntity datebase) {
        return datebaseRepository.deleteBatchDatebaseByParam(datebase);
    }

    @Override
    public int modifyDatebaseByKey(DatebaseEntity datebase) {
        if(datebase.getId() == null) {
            LOGGER.error("--> id 不能为null！" );
            return 0;
        }
        return datebaseRepository.updateDatebaseByKey(datebase);
	}

    @Override
    public int modifyBatchDatebaseByKey(List<DatebaseEntity> datebaseList) {
        for(DatebaseEntity datebase : datebaseList) {
            if(datebase.getId() == null) {
                LOGGER.error("--> id 不能为null！" + datebase);
                return 0;
            }
        }
        return datebaseRepository.updateBatchDatebaseByKey(datebaseList);
	}

    @Override
    public DatebaseEntity getDatebaseByKey(Integer id) {
        return datebaseRepository.getDatebaseByKey(id);
	}

    @Override
    public List<DatebaseEntity> listDatebaseByKey(List<Integer> ids) {
        return datebaseRepository.listDatebaseByKey(ids);
	}

    @Override
    public List<DatebaseEntity> listDatebase() {
        return datebaseRepository.listDatebase();
	}

    @Override
    public List<DatebaseEntity> listDatebaseByParam(DatebaseEntity datebase) {
        return datebaseRepository.listDatebaseByParam(datebase);
	}

    @Override
    public PageInfo<DatebaseEntity> listDatebaseByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<DatebaseEntity> personList = datebaseRepository.listDatebase();
        return new PageInfo<DatebaseEntity>(personList);
	}

    @Override
    public PageInfo<DatebaseEntity> listDatebaseByParamAndPage(DatebaseEntity datebase, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<DatebaseEntity> personList = datebaseRepository.listDatebaseByParam(datebase);
        return new PageInfo<DatebaseEntity>(personList);
	}

}
