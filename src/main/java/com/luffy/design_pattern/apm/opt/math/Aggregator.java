package com.luffy.design_pattern.apm.opt.math;

import com.luffy.design_pattern.apm.opt.bean.RequestInfo;
import com.luffy.design_pattern.apm.opt.bean.RequestStat;

import java.util.*;

/**
 * 根据原始数据计算统计数据
 *
 * @author sunzhangfei
 * @since 2021/8/17 7:49 下午
 */
public class Aggregator {
    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {


        Map<String, RequestStat> stats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            // 第 2 个代码逻辑：根据原始数据，计算得到统计数据；
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            stats.put(apiName, requestStat);
        }
        return stats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long) tps(respTimes.size(), durationInMillis / 1000));
        return requestStat;
    }

    // 以下的函数的代码实现均省略...
    private double max(List<Double> dataset) {
        double result = 0;
        //。。。
        return result;
    }

    private double min(List<Double> dataset) {
        double result = 0;
        //。。。
        return result;
    }

    private double avg(List<Double> dataset) {
        double result = 0;
        //。。。
        return result;
    }

    private double tps(int count, double duration) {
        double result = 0;
        //。。。
        return result;
    }

    private double percentile999(List<Double> dataset) {
        double result = 0;
        //。。。
        return result;
    }

    private double percentile99(List<Double> dataset) {
        double result = 0;
        //。。。
        return result;
    }

    private double percentile(List<Double> dataset, double ratio) {
        double result = 0;
        //。。。
        return result;
    }
}