package com.luffy.design_pattern.apm.opt;

import java.util.List;
import java.util.Map;

/**
 * 原始数据存储
 *
 * @author sunzhangfei
 * @since 2021/8/17 7:49 下午
 */
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo info);

    List<RequestInfo> getRequestInfos(String apiName, long startTimeMils, long endTimeMils);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeMils, long endTimeMils);
}