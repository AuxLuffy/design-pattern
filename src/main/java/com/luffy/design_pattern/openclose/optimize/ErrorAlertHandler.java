package com.luffy.design_pattern.openclose.optimize;

import com.luffy.design_pattern.openclose.AlertRuleManager;
import com.luffy.design_pattern.openclose.Notification;

/**
 * @author sunzhangfei
 * @since 2021/7/27 8:06 下午
 */
public class ErrorAlertHandler extends AlertHandler{
    public ErrorAlertHandler(AlertRuleManager ruleManager, Notification notification) {
        super(ruleManager, notification);
    }

    @Override
    public void check(ApiStatInfo info) {
        if (info.getApi() == null) {
            return;
        }
        AlertRuleManager.Rule matchedRules = ruleManager.getMatchedRules(info.getApi());
        if (info.getErrorCount() > matchedRules.getMaxErrorCount()) {
            notification.notify(Notification.NotificationLevel.SEVERE, "总量超出阈值");
        }
    }
}