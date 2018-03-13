package com.heqing.service.impl;

import com.heqing.entity.orm.Column;
import com.heqing.service.ColumnService;
import com.heqing.service.DatebaseServiceExt;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 获取数据库 表 列信息实现类
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/03
 */
@Service
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    DatebaseServiceExt datebaseServiceExt;

    @Override
    public List<Column> listColumnByTable(Integer dbId, String tableName) {
        SqlSession sqlSession = datebaseServiceExt.getSqlSession(dbId);
        if(sqlSession == null) {
            return null;
        }
        List<Column> columnList = listColumnByTable(sqlSession, tableName);
        sqlSession.clearCache();
        sqlSession.close();
        return columnList;
    }

    @Override
    public List<Column> listColumnByTable(SqlSession sqlSession, String tableName) {
        return sqlSession.selectList("com.heqing.repository.ColumnRepository.listColumnByTable",tableName);
    }

}
