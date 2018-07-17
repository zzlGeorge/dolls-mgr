package com.bootdo.common.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author mading
 * @desc bigint 类型映射
 * @date 2018/7/17
 **/
@MappedJdbcTypes(JdbcType.BIGINT)
public class BigintTypeHandler extends BaseTypeHandler<Long> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Long aLong, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i, aLong);
    }

    @Override
    public Long getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getLong(s);
    }

    @Override
    public Long getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getLong(i);
    }

    @Override
    public Long getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getLong(i);
    }
}
