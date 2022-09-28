package com.luffy.design_pattern.stragedy.algs;

import com.luffy.design_pattern.stragedy.ISortAlg;

/**
 * 利用多机mapreduce排序
 *
 * @author sunzhangfei
 * @since 2022/9/28 4:51 下午
 */
public class MapReduceSort implements ISortAlg {
    @Override
    public void sortFile(String filePath) {
        L.debug(this.getClass().getSimpleName(), "filePath: " + filePath);
    }
}
