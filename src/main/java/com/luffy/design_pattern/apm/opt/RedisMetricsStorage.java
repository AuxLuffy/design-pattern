package com.luffy.design_pattern.apm.opt;

import java.util.List;
import java.util.Map;

/**
 * redis存储数据
 *
 * @author sunzhangfei
 * @since 2021/8/17 7:52 下午
 */
public class RedisMetricsStorage implements MetricsStorage {
    @Override
    public void saveRequestInfo(RequestInfo info) {

    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeMils, long endTimeMils) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeMils, long endTimeMils) {
        return null;
    }
}