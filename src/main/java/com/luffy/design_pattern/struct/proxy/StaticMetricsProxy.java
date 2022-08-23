package com.luffy.design_pattern.struct.proxy;

import com.luffy.design_pattern.apm.opt.bean.RequestInfo;
import com.luffy.design_pattern.apm.opt.collector.MetricsCollector;
import com.luffy.design_pattern.apm.opt.storage.RedisMetricsStorage;
import com.luffy.design_pattern.common.IUserController;
import com.luffy.design_pattern.common.UserController;
import com.luffy.design_pattern.common.UserVo;

/**
 * 统计用户接口调用时间静态代理类
 *
 * @author sunzhangfei
 * @since 2022/5/6 3:40 下午
 */
public class StaticMetricsProxy implements IUserController {
    private UserController userController;
    MetricsCollector metricsCollector;
    public StaticMetricsProxy(UserController userController) {
        this.userController = userController;
        RedisMetricsStorage storage = new RedisMetricsStorage();
        this.metricsCollector = new MetricsCollector(storage);
    }

    @Override
    public UserVo login(String phone, String password) {
        long startTimeStamp = System.currentTimeMillis();
        UserVo userVo = userController.login(phone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimeStamp;
        metricsCollector.recordRequest(new RequestInfo("login", responseTime, startTimeStamp));
        return userVo;
    }

    @Override
    public UserVo register(String phone, String password) {
        long startTimeStamp = System.currentTimeMillis();
        UserVo userVo = userController.register(phone, password);
        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimeStamp;
        metricsCollector.recordRequest(new RequestInfo("register", responseTime, startTimeStamp));
        return userVo;
    }
}