package com.luffy.design_pattern.visit.factory.extractor;

import com.luffy.design_pattern.opt.Logutil;
import com.luffy.design_pattern.visit.SourceFile;

/**
 * @author sunzhangfei
 * @since 2022/8/25 11:56 上午
 */
public class DocExtractor implements IExtractor{
    @Override
    public void extract2Txt(SourceFile file) {
        Logutil.d("doc转化为txt");
    }
}
