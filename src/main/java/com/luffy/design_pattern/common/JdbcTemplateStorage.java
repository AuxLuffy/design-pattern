package com.luffy.design_pattern.common;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JdbcTemplate实现数据库dao
 *
 * @author sunzhangfei
 * @since 2022/8/22 10:52 上午
 */
public class JdbcTemplateStorage implements IUserStorable {
    private final JdbcTemplate jdbcTemplate;
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=UTF8&useSSL=true&serverTimezone=UTC";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "asdfghjkl";

    public JdbcTemplateStorage() {
        this.jdbcTemplate = new JdbcTemplate();
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUser(USER_NAME);
        mysqlDataSource.setPassword(PASSWORD);
        mysqlDataSource.setURL(URL);
        jdbcTemplate.setDataSource(mysqlDataSource);
    }

    @Override
    public void storeUser(UserVo user) {

    }

    @Override
    public UserVo queryUser(String cellphone) {
        String sql = "select * from demo.table1 where cellphone=?";
        return jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, cellphone);
                return ps;
            }
        }, new UserRowMapper()).get(0);
//        return jdbcTemplate.query(sql, new UserRowMapper()).get(0);
    }

    @Override
    public void updateUser(UserVo user) {

    }

    @Override
    public void deleteUser(String cellphone) {

    }

    private class UserRowMapper implements RowMapper<UserVo> {
        @Override
        public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserVo userVo = new UserVo();
            userVo.setId(rs.getLong("id"));
            userVo.setName(rs.getString("name"));
            userVo.setCellphone(rs.getString("cellphone"));
            return userVo;
        }
    }

    public static void main(String[] args) {
        JdbcTemplateStorage storage = new JdbcTemplateStorage();
        UserVo userVo = storage.queryUser("15836595335");
        System.out.println("" + userVo.toString());
    }
}
