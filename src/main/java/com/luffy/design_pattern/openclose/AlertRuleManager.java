package com.luffy.design_pattern.openclose;


import org.jetbrains.annotations.NotNull;

;

/**
 * @author sunzhangfei
 * @since 2021/7/27 7:21 下午
 */
public class AlertRuleManager {

    public Rule getMatchedRules(@NotNull String api) {
        Rule rule = null;
        for (Rule r : Rule.values()) {
            if (api.equals(r.api)) {
                return r;
            }
        }
        return rule;
    }

    public enum Rule {
        none(null, 0, 0),
        api1("", 2, 3),
        api2("", 4, 1000),
        api3("", 5, 100000),
        api4("", 6, 100000),
        api5("7", 7, 1000000000);
        String api;
        long maxTps;
        long maxErrorCount;
        long maxTimeoutCount = 5000;

        Rule(String api, long maxTps, long maxCount) {
            this.api = api;
            this.maxTps = maxTps;
            this.maxErrorCount = maxCount;
        }

        public long getMaxTps() {
            return maxTps;
        }

        public long getMaxErrorCount() {
            return maxErrorCount;
        }

        public long getMaxTimeoutCount() {
            return maxTimeoutCount;
        }
    }
}