package com.luffy.design_pattern.apm.opt.view;

import com.google.gson.Gson;
import com.luffy.design_pattern.apm.opt.bean.RequestStat;

import java.util.Map;

/**
 * desc: 把数据统计输出到控制台
 *
 * @author luffy
 * @since 2021/8/17 23:14
 */
public class ConsoleViewer implements IStatViewer{
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeMillis, long endTimeMillis) {
        System.out.println("Time Span: [" + startTimeMillis + ", " + endTimeMillis + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
