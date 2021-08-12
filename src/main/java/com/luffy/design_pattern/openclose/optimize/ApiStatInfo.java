package com.luffy.design_pattern.openclose.optimize;

/**
 * @author sunzhangfei
 * @since 2021/7/27 8:00 下午
 */
public class ApiStatInfo {
    private String api;
    private long requestCount;
    private long errorCount;
    private long durationOfSeconds;
    private long timeOutCount;

    public ApiStatInfo(String api, long requestCount, long errorCount, long durationOfSeconds) {
        this.api = api;
        this.requestCount = requestCount;
        this.errorCount = errorCount;
        this.durationOfSeconds = durationOfSeconds;
    }

    public long getTimeOutCount() {
        return timeOutCount;
    }

    public void setTimeOutCount(long timeOutCount) {
        this.timeOutCount = timeOutCount;
    }

    public String getApi() {
        return api;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public long getDurationOfSeconds() {
        return durationOfSeconds;
    }
}