package com.luffy.design_pattern.stragedy;

import com.luffy.design_pattern.utils.NetUtil;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 排序
 *
 * @author sunzhangfei
 * @since 2022/9/28 4:38 下午
 */
public interface ISortAlg {
    Logger L = LoggerFactory.getLogger("sort");
    void sortFile(String filePath);
}
