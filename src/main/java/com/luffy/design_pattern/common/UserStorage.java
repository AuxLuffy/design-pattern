package com.luffy.design_pattern.common;

import com.mysql.cj.jdbc.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * @author sunzhangfei
 * @since 2022/5/6 7:50 下午
 */
public class UserStorage implements IUserStorable {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=UTF8&useSSL=true&serverTimezone=UTC";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "asdfghjkl";
    static Logger L = LoggerFactory.getLogger(UserStorage.class.getSimpleName());
    private Connection conn;

    public UserStorage() {
        try {
            Class.forName(DRIVER_NAME);
            this.conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        if (this.conn == null) {
            L.error("创建数据库连接失败");
        } else {
            L.error("创建数据库连接成功");
        }

    }

    @Override
    public void storeUser(UserVo user) {
        //存储用户信息
        if (conn == null) {
            L.error("数据库连接为空");
            return;
        }
        PreparedStatement ps = null;
        String sql = "insert into demo.table1 (id, name, cellphone) value(?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getCellPhone());
            int i = ps.executeUpdate();
            L.error(ps.toString());
            if (i > 0) {
                L.error("新增数据成功");
            } else {
                L.error("新增数据失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    @Override
    public UserVo queryUser(String cellphone) {
        if (conn == null) {
            L.error("数据库连接为空");
            return null;
        }
        PreparedStatement prst = null;
        ResultSet resultSet = null;
        //根据id查用户
        String sql = "SELECT * from demo.table1";
        try {
            prst = conn.prepareStatement(sql);
            resultSet = prst.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("cellphone");
                long id = resultSet.getLong("id");
                if (cellphone.equals(phone)) {
                    UserVo userVo = new UserVo(phone);
                    userVo.setName(name);
                    userVo.setId(id);
                    return userVo;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void updateUser(UserVo user) {
        if (conn == null) {
            L.error("数据库连接为空");
            return;
        }
        //更新用户信息
        //存储用户信息
        if (conn == null) {
            L.error("数据库连接为空");
            return;
        }
        PreparedStatement ps = null;
//        String sql = "replace demo.table1(name,cellphone) values(?,?)";
        String sql = "update demo.table1 set name=? where cellphone=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getCellPhone());
            int i = ps.executeUpdate();
            L.error(ps.toString());
            if (i > 0) {
                L.error("更新数据成功");
            } else {
                L.error("更新数据失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void deleteUser(String cellphone) {
        if (conn == null) {
            L.error("数据库连接为空");
            return;
        }
        //删除用户
        if (conn == null) {
            L.error("数据库连接为空");
            return;
        }
        //更新用户信息
        //存储用户信息
        if (conn == null) {
            L.error("数据库连接为空");
            return;
        }
        PreparedStatement ps = null;
        String sql = "delete from demo.table1 where cellphone=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, cellphone);
            int i = ps.executeUpdate();
            L.error(ps.toString());
            if (i > 0) {
                L.error("更新数据成功");
            } else {
                L.error("更新数据失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void release() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }

    public static void main(String[] args) {
        UserStorage us = new UserStorage();
        UserVo userVo = us.queryUser("110");
        if (userVo != null) {
            L.debug(userVo.toString());
        } else {
            L.error("没有找到");
        }

//        us.storeUser(new UserVo(1, "xtnu", "110"));
        us.updateUser(new UserVo(5, "happy", "158"));
    }
}
