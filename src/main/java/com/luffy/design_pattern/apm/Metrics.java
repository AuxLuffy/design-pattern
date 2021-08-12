package com.luffy.design_pattern.apm;

import com.google.gson.Gson;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 记录接口耗时及访问时间
 *
 * @author sunzhangfei
 * @since 2021/8/6 4:58 下午
 */
public class Metrics {
    private Map<String, List<Double>> responseTimes = new HashMap<String, List<Double>>();
    private Map<String, List<Double>> timeStamps = new HashMap<String, List<Double>>();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void recordResponseTime(String apiName, double responseTime) {
        responseTimes.putIfAbsent(apiName, new ArrayList<>());
        responseTimes.get(apiName).add(responseTime);
    }

    public void recordTimestamps(String apiName, double timestamp) {
        timeStamps.putIfAbsent(apiName, new ArrayList<>());
        timeStamps.get(apiName).add(timestamp);
    }

    public void startRepeatedReport(long period, TimeUnit unit) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                Map<String, Map<String, Double>> stats = new HashMap<>();
                for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
                    String apiName = entry.getKey();
                    List<Double> apiResponseTimes = entry.getValue();
                    stats.putIfAbsent(apiName, new HashMap<>());
                    stats.get(apiName).put("max", max(apiResponseTimes));
                    stats.get(apiName).put("avg", avg(apiResponseTimes));
                }
                for (Map.Entry<String, List<Double>> entry : timeStamps.entrySet()) {
                    String apiName = entry.getKey();
                    List<Double> timestamps = entry.getValue();
                    stats.putIfAbsent(apiName, new HashMap<>());
                    stats.get(apiName).put("count", (double) timestamps.size());
                }
                System.out.println(gson.toJson(stats));
            }
        }, 0, period, unit);
    }

    private Double max(List<Double> apiResponseTimes) {
        Double max = Collections.max(apiResponseTimes);
        return max;
    }

    private Double avg(List<Double> apiResponseTimes) {
        Double avg, sum = 0d;
        for (Double responseTime : apiResponseTimes) {
            sum += responseTime;
        }
        return sum / apiResponseTimes.size();
    }
}