package com.luffy.design_pattern.stragedy;

import com.luffy.design_pattern.stragedy.algs.ConcurrentExternalSort;
import com.luffy.design_pattern.stragedy.algs.ExternalSort;
import com.luffy.design_pattern.stragedy.algs.MapReduceSort;
import com.luffy.design_pattern.stragedy.algs.QuickSort;
import com.mysql.cj.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 排序算法工厂
 *
 * @author sunzhangfei
 * @since 2022/9/28 4:40 下午
 */
public class SortAlgFactory {
    public static final String QUICK_SORT = "quickSort";
    public static final String EXTERNAL_SORT = "externalSort";
    public static final String CONCURRENT_EXTERNAL_SORT = "concurrentExternalSort";
    public static final String MAP_REDUCE_SORT = "mapReduceSort";
    private static Map<String, ISortAlg> sortAlgMap = new HashMap<>();

    static {
        sortAlgMap.put(QUICK_SORT, new QuickSort());
        sortAlgMap.put(EXTERNAL_SORT, new ExternalSort());
        sortAlgMap.put(CONCURRENT_EXTERNAL_SORT, new ConcurrentExternalSort());
        sortAlgMap.put(MAP_REDUCE_SORT, new MapReduceSort());
    }

    public static ISortAlg getSortAlg(String algName) {
        if (StringUtils.isNullOrEmpty(algName)) {
            throw new IllegalArgumentException("algrithm name must not be null or empty!");
        }
        return sortAlgMap.get(algName);
    }
}
