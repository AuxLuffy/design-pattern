package com.luffy.design_pattern.struct.proxy;

import com.luffy.design_pattern.apm.opt.bean.RequestInfo;
import com.luffy.design_pattern.apm.opt.collector.MetricsCollector;
import com.luffy.design_pattern.apm.opt.storage.RedisMetricsStorage;
import com.luffy.design_pattern.common.IUserController;
import com.luffy.design_pattern.common.UserController;
import com.luffy.design_pattern.common.UserStorage;
import com.luffy.design_pattern.common.UserVo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 统计用户接口调用时间动态代理类
 *
 * @author sunzhangfei
 * @since 2022/5/17 6:11 下午
 */
public class DynamicMetricsProxy {
    private MetricsCollector metricsCollector;

    public DynamicMetricsProxy() {
        this.metricsCollector = new MetricsCollector(new RedisMetricsStorage());
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, new DynamicProxyHandler(proxiedObject));
    }

    private class DynamicProxyHandler implements InvocationHandler {

        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimeStamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimeStamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            metricsCollector.recordRequest(new RequestInfo(apiName, responseTime, startTimeStamp));
            return result;
        }
    }

    public static void main(String[] args) {
        DynamicMetricsProxy proxy = new DynamicMetricsProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController(new UserStorage()));
//        userController.register("15836595335", "123456");
        userController.login("15836595335", "123456");
    }
}
