package com.luffy.design_pattern.stragedy.algs;

import com.luffy.design_pattern.stragedy.ISortAlg;

/**
 * 快排
 *
 * @author sunzhangfei
 * @since 2022/9/28 4:46 下午
 */
public class QuickSort implements ISortAlg {
    @Override
    public void sortFile(String filePath) {
        L.debug(this.getClass().getSimpleName(), "filePath: " + filePath);
    }
}
