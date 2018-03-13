package com.heqing.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heqing.entity.orm.Table;
import com.heqing.service.DatebaseServiceExt;
import com.heqing.service.TableService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    DatebaseServiceExt datebaseServiceExt;

    @Override
    public Table getTableByName(Integer dbId, String tableName) {
        SqlSession sqlSession = datebaseServiceExt.getSqlSession(dbId);
        if(sqlSession == null) {
            return null;
        }
        Table Table = getTableByName(sqlSession, tableName);
        sqlSession.clearCache();
        sqlSession.close();
        return Table;
    }

    @Override
    public Table getTableByName(SqlSession sqlSession, String tableName) {
        return (Table)sqlSession.selectOne("com.heqing.repository.TableRepository.getTableByName", tableName);
    }

    @Override
    public List<Table> listTable(Integer dbId) {
        SqlSession sqlSession = datebaseServiceExt.getSqlSession(dbId);
        if(sqlSession == null) {
            return null;
        }
        List<Table> tableList = listTable(sqlSession);
        sqlSession.clearCache();
        sqlSession.close();
        return tableList;
    }

    @Override
    public List<Table> listTable(SqlSession sqlSession) {
        return sqlSession.selectList("com.heqing.repository.TableRepository.listTable");
    }

    @Override
    public PageInfo<Table> listTableByParamAndPage(Integer dbId, String tableName, int pageNo, int pageSize) {
        SqlSession sqlSession = datebaseServiceExt.getSqlSession(dbId);
        if(sqlSession == null) {
            return null;
        }
        PageInfo<Table> tablePage = listTableByParamAndPage(sqlSession, tableName, pageNo, pageSize);
        sqlSession.clearCache();
        sqlSession.close();
        return tablePage;
    }

    @Override
    public PageInfo<Table> listTableByParamAndPage(SqlSession sqlSession, String tableName, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Table> tableList = sqlSession.selectList("com.heqing.repository.TableRepository.listTableByParamAndPage", tableName);
        return new PageInfo<Table>(tableList);
    }
}
