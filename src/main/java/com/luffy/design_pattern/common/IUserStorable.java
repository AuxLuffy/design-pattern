package com.luffy.design_pattern.common;

/**
 * @author sunzhangfei
 * @since 2022/5/6 7:51 下午
 */
interface IUserStorable {
    void storeUser(UserVo user);

    UserVo queryUser(String cellphone);

    void updateUser(UserVo user);

    void deleteUser(String cellphone);
}
