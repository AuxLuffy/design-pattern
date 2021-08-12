package com.luffy.design_pattern.openclose.optimize;

import com.luffy.design_pattern.openclose.AlertRuleManager;
import com.luffy.design_pattern.openclose.Notification;

/**
 * 访问超时报警处理
 *
 * @author sunzhangfei
 * @since 2021/7/27 8:11 下午
 */
public class TimeOutAlertHandler extends AlertHandler {

    public TimeOutAlertHandler(AlertRuleManager ruleManager, Notification notification) {
        super(ruleManager, notification);
    }

    @Override
    public void check(ApiStatInfo info) {
        if (info.getApi() == null) {
            return;
        }
        AlertRuleManager.Rule matchedRules = ruleManager.getMatchedRules(info.getApi());
        if (info.getTimeOutCount() > matchedRules.getMaxTimeoutCount()) {
            notification.notify(Notification.NotificationLevel.SEVERE, "超时总量超出阈值");
        }
    }
}