package com.heqing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heqing.entity.Datebase;
import com.heqing.entity.orm.TableEntity;
import com.heqing.service.TableService;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 获取数据库 表信息实现类
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/03
 */
@Service
public class TableServiceImpl implements TableService {

    @Override
    public TableEntity getTableByName(SqlSession sqlSession, String tableName) {
        return (TableEntity)sqlSession.selectOne("com.heqing.dao.TableDao.getTableByName", tableName);
    }

    @Override
    public List<TableEntity> listTable(SqlSession sqlSession) {
        return sqlSession.selectList("com.heqing.dao.TableDao.listTable");
    }

    @Override
    public List<TableEntity> listTableByParamAndPage(SqlSession sqlSession, String tableName, int pageNo, int pageSize) {
        RowBounds row = new RowBounds((pageNo-1)*pageSize, pageSize);
        return sqlSession.selectList("com.heqing.dao.TableDao.listTableByParamAndPage", tableName, row);
    }

    @Override
    public Long countTableByParamAndPage(SqlSession sqlSession, String tableName) {
        return (Long)sqlSession.selectOne("com.heqing.dao.TableDao.countTableByParamAndPage", tableName);
    }
}
