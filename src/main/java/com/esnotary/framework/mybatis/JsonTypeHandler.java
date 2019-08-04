package com.esnotary.framework.mybatis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: zhiwei
 * @Date: 2018/10/8 20:32
 * @Description: mybatis json对象转换
 */
public class JsonTypeHandler extends BaseTypeHandler<JSON> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, JSON jsonNode, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,toJsonString(jsonNode));
    }

    @Override
    public JSON getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return parse(resultSet.getString(s));
    }

    @Override
    public JSON getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return parse(resultSet.getString(i));
    }

    @Override
    public JSON getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return parse(callableStatement.getString(i));
    }

    private JSON parse(String json){
        if(json == null || json.length() == 0) {
            return null;
        }
        Object object = JSONObject.parse(json);
        if (object instanceof JSONObject){
            return (JSONObject) object;
        }else if(object instanceof JSONArray) {
            return (JSONArray) object;
        }else {
            return null;
        }
    }

    private String toJsonString(Object o){
        return JSONObject.toJSONString(o);
    }
}
