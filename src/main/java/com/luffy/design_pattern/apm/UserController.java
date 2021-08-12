package com.luffy.design_pattern.apm;

import com.luffy.design_pattern.wallet.anemic.controller.UserVo;

import java.util.concurrent.TimeUnit;

/**
 * 用户注册登录服务
 * 统计此类中的方法耗时
 *
 * @author sunzhangfei
 * @since 2021/8/6 4:55 下午
 */
public class UserController {
    private Metrics metrics = new Metrics();

    public UserController() {
        metrics.startRepeatedReport(300, TimeUnit.SECONDS);
    }

    public void register(UserVo user) {
        long startTime = System.currentTimeMillis();
        metrics.recordTimestamps("register", startTime);
        //。。。
        metrics.recordResponseTime("register", System.currentTimeMillis() - startTime);
    }

    public UserVo login(String phone, String password) {
        long startTime = System.currentTimeMillis();
        metrics.recordTimestamps("login", startTime);
        UserVo user = null;
        //。。。
        metrics.recordResponseTime("login", System.currentTimeMillis() - startTime);
        return user;
    }
}