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
    private Long startTimeStamp = 0L;

    public RequestInfo(String apiName) {
        this.apiName = apiName;
    }

    public RequestInfo(String apiName, Long responseTime, Long timeStamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.startTimeStamp = timeStamp;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    public Long getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(Long startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public String getApiName() {
        return apiName;
    }
}