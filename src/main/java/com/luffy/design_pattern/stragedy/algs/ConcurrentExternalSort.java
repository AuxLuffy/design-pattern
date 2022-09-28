package com.luffy.design_pattern.stragedy.algs;

import com.luffy.design_pattern.stragedy.ISortAlg;

/**
 * 多线程外部排序
 *
 * @author sunzhangfei
 * @since 2022/9/28 4:50 下午
 */
public class ConcurrentExternalSort implements ISortAlg {
    @Override
    public void sortFile(String filePath) {
        L.debug(this.getClass().getSimpleName(), "filePath: " + filePath);
    }
}
