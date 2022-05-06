package com.luffy.design_pattern.apm.opt.view;

import com.luffy.design_pattern.apm.opt.math.Aggregator;
import com.luffy.design_pattern.apm.opt.storage.MetricsStorage;
import com.luffy.design_pattern.apm.opt.bean.RequestInfo;
import com.luffy.design_pattern.apm.opt.bean.RequestStat;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 以一定频率统计并发送统计到命令行
 *
 * @author sunzhangfei
 * @since 2021/8/17 7:50 下午
 */
public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;
    private Aggregator aggregator;
    private IStatViewer statViewer;

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, IStatViewer statViewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.statViewer = statViewer;
        executor = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * 每隔一定频率做一次数据分析并将数据分析输出到控制台上
     *
     * @param periodInSeconds   频率，单位秒
     * @param durationInSeconds 多长时间内的
     */
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(() -> {
            long durationInMillis = durationInSeconds * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;
            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
            Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
            statViewer.output(stats, startTimeInMillis, endTimeInMillis);
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }

}