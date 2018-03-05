package com.heqing.service.impl;

import com.heqing.entity.orm.ColumnEntity;
import com.heqing.service.ColumnService;
import org.apache.ibatis.session.SqlSession;
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

    @Override
    public List<ColumnEntity> listColumnByTable(SqlSession sqlSession, String tableName) {
        return sqlSession.selectList("com.heqing.dao.ColumnDao.listColumnByTable",tableName);
    }
}
