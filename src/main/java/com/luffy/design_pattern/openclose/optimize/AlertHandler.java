package com.luffy.design_pattern.openclose.optimize;

import com.luffy.design_pattern.openclose.AlertRuleManager;
import com.luffy.design_pattern.openclose.Notification;

/**
 * @author sunzhangfei
 * @since 2021/7/27 7:57 下午
 */
public abstract class AlertHandler {
    protected AlertRuleManager ruleManager;
    protected Notification notification;

    public AlertHandler(AlertRuleManager ruleManager, Notification notification) {
        this.ruleManager = ruleManager;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo info);
}