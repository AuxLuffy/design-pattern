package com.luffy.design_pattern.apm.opt.bean;

/**
 * 采集器收集到的原始信息
 *
 * @author sunzhangfei
 * @since 2021/8/17 7:53 下午
 */
public class RequestInfo {
    private final String apiName;
    private Long responseTime = 0L;
    private Long timeStamp = 0L;

    public RequestInfo(String apiName) {
        this.apiName = apiName;
    }

    public RequestInfo(String apiName, Long responseTime, Long timeStamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timeStamp = timeStamp;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getApiName() {
        return apiName;
    }
}