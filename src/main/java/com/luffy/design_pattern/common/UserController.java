package com.luffy.design_pattern.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sunzhangfei
 * @since 2022/5/6 7:46 下午
 */
public class UserController implements IUserController {

    Logger L = LoggerFactory.getLogger(UserStorage.class.getSimpleName());
    IUserStorable storeUtil;

    public UserController(IUserStorable storeUtil) {
        this.storeUtil = storeUtil;
    }

    @Override
    public UserVo login(String phone, String password) {
        UserVo userVo1 = storeUtil.queryUser(phone);
        if (userVo1 == null) {
            L.error("登录失败，用户不存在，请先注册");
        } else {
            L.error("登录成功" + userVo1);
        }
        return userVo1;
    }

    @Override
    public UserVo register(String phone, String password) {
        UserVo temp = storeUtil.queryUser(phone);
        if (temp != null) {
            L.error("用户已经存在了");
        } else {
            storeUtil.storeUser(new UserVo(phone, password));
            L.error("用户不存在，新创建");
            temp = storeUtil.queryUser(phone);
        }
        return temp;
    }
}
