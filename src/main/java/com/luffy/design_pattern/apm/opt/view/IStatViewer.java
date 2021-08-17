package com.luffy.design_pattern.apm.opt.view;

import com.luffy.design_pattern.apm.opt.bean.RequestStat;

import java.util.Map;

/**
 * desc: 数据显示类
 *
 * @author luffy
 * @since 2021/8/17 23:03
 */
public interface IStatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeMillis, long endTimeMillis);
}
