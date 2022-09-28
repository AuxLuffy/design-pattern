package com.luffy.design_pattern.stragedy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 提供排序入口，接收文件名，其它逻辑在此内完成
 *
 * @author sunzhangfei
 * @since 2022/9/28 4:40 下午
 */
public class Sorter {
    public static final long GB = 1024 * 1024 * 1024;
    private static List<AlgRange> algRanges = new ArrayList<>();

    static {
        algRanges.add(new AlgRange(0L, 6 * GB, SortAlgFactory.getSortAlg(SortAlgFactory.QUICK_SORT)));
        algRanges.add(new AlgRange(6 * GB, 10 * GB, SortAlgFactory.getSortAlg(SortAlgFactory.EXTERNAL_SORT)));
        algRanges.add(new AlgRange(10 * GB, 100 * GB, SortAlgFactory.getSortAlg(SortAlgFactory.CONCURRENT_EXTERNAL_SORT)));
        algRanges.add(new AlgRange(100 * GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg(SortAlgFactory.MAP_REDUCE_SORT)));
    }

    public void sort(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("the file(\"" + path + "\") does not exits!");
        }
        ISortAlg alg = null;
        long length = file.length();
        for (AlgRange rang : algRanges) {
            if (rang.isInRange(length)) {
                alg = rang.getAlg();
                break;
            }
        }
        if (alg != null) {
            alg.sortFile(path);
        }
    }


    public static final class AlgRange {
        private long start;
        private long end;
        private ISortAlg mSortAlg;

        public AlgRange(long start, long end, ISortAlg sortAlg) {
            this.start = start;
            this.end = end;
            mSortAlg = sortAlg;
        }

        public boolean isInRange(long fileLength) {
            if (fileLength >= start && fileLength < end) {
                return true;
            }
            return false;
        }

        public ISortAlg getAlg() {
            return mSortAlg;
        }
    }
}
