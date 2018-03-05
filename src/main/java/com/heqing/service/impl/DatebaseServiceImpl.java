package com.heqing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heqing.dao.DatebaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.log4j.Logger;

import com.heqing.entity.Datebase;
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
	private DatebaseDao datebaseDao;

    @Override
    public int saveDatebase(Datebase datebase) {
        return datebaseDao.insertDatebase(datebase);
	}

    @Override
    public int saveBatchDatebase(List<Datebase> datebaseList) {
        return datebaseDao.insertBatchDatebase(datebaseList);
	}

    @Override
    public int removeDatebaseByKey(Integer id) {
        return datebaseDao.deleteDatebaseByKey(id);
	}

    @Override
    public int removeBatchDatebaseByKey(List<Integer> ids) {
        return datebaseDao.deleteBatchDatebaseByKey(ids);
	}

    @Override
    public int removeBatchDatebaseByParam(Datebase datebase) {
        return datebaseDao.deleteBatchDatebaseByParam(datebase);
    }

    @Override
    public int modifyDatebaseByKey(Datebase datebase) {
        if(datebase.getId() == null) {
            LOGGER.error("--> id 不能为null！" );
            return 0;
        }
        return datebaseDao.updateDatebaseByKey(datebase);
	}

    @Override
    public int modifyBatchDatebaseByKey(List<Datebase> datebaseList) {
        for(Datebase datebase : datebaseList) {
            if(datebase.getId() == null) {
                LOGGER.error("--> id 不能为null！" + datebase);
                return 0;
            }
        }
        return datebaseDao.updateBatchDatebaseByKey(datebaseList);
	}

    @Override
    public Datebase getDatebaseByKey(Integer id) {
        return datebaseDao.getDatebaseByKey(id);
	}

    @Override
    public List<Datebase> listDatebaseByKey(List<Integer> ids) {
        return datebaseDao.listDatebaseByKey(ids);
	}

    @Override
    public List<Datebase> listDatebase() {
        return datebaseDao.listDatebase();
	}

    @Override
    public List<Datebase> listDatebaseByParam(Datebase datebase) {
        return datebaseDao.listDatebaseByParam(datebase);
	}

    @Override
    public Page<Datebase> listDatebaseByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return (Page<Datebase>)datebaseDao.listDatebase();
	}

    @Override
    public Page<Datebase> listDatebaseByParamAndPage(Datebase datebase, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return (Page<Datebase>)datebaseDao.listDatebaseByParam(datebase);
	}

}
