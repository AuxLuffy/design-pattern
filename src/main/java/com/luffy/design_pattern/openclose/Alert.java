package com.luffy.design_pattern.openclose;


/**
 * api警告系统
 *
 * @author sunzhangfei
 * @since 2021/7/27 7:15 下午
 */
public class Alert {
    AlertRuleManager rule;
    Notification notification;

    public Alert(AlertRuleManager rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public void check(String api, long requestCount, long errorcount, long durationOfSeconds) {
        if(api == null) {
            return;
        }
        long tps = requestCount / durationOfSeconds;
        AlertRuleManager.Rule matchedRules = rule.getMatchedRules(api);
        if (tps > matchedRules.getMaxTps()) {
            notification.notify(Notification.NotificationLevel.URGENCY, "每秒均值超出阈值");
        }
        if (errorcount > matchedRules.getMaxErrorCount()) {
            notification.notify(Notification.NotificationLevel.SEVERE, "总量超出阈值");
        }
    }
}