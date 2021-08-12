package com.luffy.design_pattern.openclose.optimize;

import java.util.HashSet;

/**
 * 优化后的api警报系统
 * 因为check方法如果再加入不同规则后需要修改里面参数及方法，所有调用的地方都要大改
 * 故
 * 1. 引入辅助类ApiStatInfo来表示要检查的一些参数
 * 2. 引入对不同功能的处理handler：AlertHandler
 *
 * @author sunzhangfei
 * @since 2021/7/27 7:52 下午
 */
public class Alert2 {

    public Alert2() {
    }

    public void addHandler(AlertHandler handler) {
        handlers.add(handler);
    }

    public HashSet<AlertHandler> handlers = new HashSet<AlertHandler>();

    public void check(ApiStatInfo info) {
        for (AlertHandler handler : handlers) {
            handler.check(info);
        }
    }

}