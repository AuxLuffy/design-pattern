package com.luffy.design_pattern.openclose.optimize;

import com.luffy.design_pattern.openclose.AlertRuleManager;
import com.luffy.design_pattern.openclose.Notification;

/**
 * 均值警报
 *
 * @author sunzhangfei
 * @since 2021/7/27 8:03 下午
 */
public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRuleManager ruleManager, Notification notification) {
        super(ruleManager, notification);
    }

    @Override
    public void check(ApiStatInfo info) {
        if (info.getApi() == null) {
            return;
        }
        long tps = info.getErrorCount() / info.getDurationOfSeconds();
        AlertRuleManager.Rule matchedRules = ruleManager.getMatchedRules(info.getApi());
        if (tps > matchedRules.getMaxTps()) {
            notification.notify(Notification.NotificationLevel.URGENCY, "每秒均值超出阈值");
        }
    }
}