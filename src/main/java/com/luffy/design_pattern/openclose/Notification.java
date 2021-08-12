package com.luffy.design_pattern.openclose;

/**
 * @author sunzhangfei
 * @since 2021/7/27 7:41 下午
 */
public class Notification {
    public void notify(NotificationLevel level, String tips) {
        System.out.println("note(level: " + level + ", tips: " + tips + ")");
    }

    public enum NotificationLevel {URGENCY, SEVERE}
}