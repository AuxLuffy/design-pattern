package com.luffy.design_pattern.wallet.anemic.controller;

import com.luffy.design_pattern.wallet.anemic.service.UserBo;
import com.luffy.design_pattern.wallet.anemic.service.UserService;

/**
 * @author sunzhangfei
 * @since 2021/7/27 2:52 下午
 */
public class UserController {
    private UserService userservice;

    public UserVo getUserById(long userId) {
        UserBo userBo = userservice.getUserById(userId);
        UserVo user = convertUserBo(userBo);
        return user;
    }

    private UserVo convertUserBo(UserBo userBo) {
        return null;
    }
}