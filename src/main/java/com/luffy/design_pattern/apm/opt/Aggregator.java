package com.luffy.design_pattern.apm.opt;

import java.util.*;

/**
 * 根据原始数据计算统计数据
 *
 * @author sunzhangfei
 * @since 2021/8/17 7:49 下午
 */
public class Aggregator {
    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {

        Map<String, List<RequestInfo>> requestInfos =
                metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> stats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            // 第 2 个代码逻辑：根据原始数据，计算得到统计数据；
            RequestStat requestStat = doAgragate(requestInfosPerApi, durationInMillis);
            stats.put(apiName, requestStat);
        }
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;
        for (RequestInfo requestInfo : requestInfos) {
            ++count;
            double respTime = requestInfo.getResponseTime();
            if (maxRespTime < respTime) {
                maxRespTime = respTime;
            }
            if (minRespTime > respTime) {
                minRespTime = respTime;
            }
            sumRespTime += respTime;
        }
        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        long tps = (long) (count / durationInMillis * 1000);
        Collections.sort(requestInfos, new Comparator<RequestInfo>() {
            @Override
            public int compare(RequestInfo o1, RequestInfo o2) {
                double diff = o1.getResponseTime() - o2.getResponseTime();
                if (diff < 0.0) {
                    return -1;
                } else if (diff > 0.0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int idx999 = (int) (count * 0.999);
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setCount(count);
        requestStat.setTps(tps);
        return requestStat;
    }

    private RequestStat doAgragate(List<RequestInfo> requestInfos, long durationInMillis) {
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