package com.luffy.design_pattern.apm.opt;

import org.apache.commons.lang3.StringUtils;

/**
 * 接口请求的采集器
 *
 * @author sunzhangfei
 * @since 2021/8/17 7:48 下午
 */
public class MetricsCollector {
    /**
     * 存储类
     */
    private MetricsStorage metricsStorage;

    //依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo info){
        if(info == null|| StringUtils.isBlank(info.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(info);
    }
}