package com.luffy.design_pattern.apm.opt.view;

import com.luffy.design_pattern.apm.opt.math.Aggregator;
import com.luffy.design_pattern.apm.opt.storage.MetricsStorage;
import com.luffy.design_pattern.apm.opt.bean.RequestInfo;
import com.luffy.design_pattern.apm.opt.bean.RequestStat;

import java.util.*;

/**
 * 以一定频率统计并发送统计至邮件
 *
 * @author sunzhangfei
 * @since 2021/8/17 7:50 下午
 */
public class EmailReporter {
    private static final long DAY_HOURS_IN_SECONDS = 86400L;
    private MetricsStorage metricsStorage;
    private IStatViewer viewer;
    private Aggregator aggregator;


    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, IStatViewer statViewer) {
        this.metricsStorage = metricsStorage;
        this.viewer = statViewer;
        this.aggregator = aggregator;
    }

    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
                viewer.output(stats, startTimeInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }
}