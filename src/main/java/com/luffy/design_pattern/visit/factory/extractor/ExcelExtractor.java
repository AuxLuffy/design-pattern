package com.luffy.design_pattern.visit.factory.extractor;

import com.luffy.design_pattern.opt.Logutil;
import com.luffy.design_pattern.visit.SourceFile;

/**
 * @author sunzhangfei
 * @since 2022/8/25 11:58 上午
 */
public class ExcelExtractor implements IExtractor{
    @Override
    public void extract2Txt(SourceFile file) {
        Logutil.d("excel转化为txt");
    }
}
