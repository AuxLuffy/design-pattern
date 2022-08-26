package com.luffy.design_pattern.visit.factory.extractor;

import com.luffy.design_pattern.opt.Logutil;
import com.luffy.design_pattern.visit.SourceFile;
import com.luffy.design_pattern.visit.factory.extractor.IExtractor;

/**
 * @author sunzhangfei
 * @since 2022/8/25 2:12 下午
 */
public class PdfExtractor implements IExtractor {
    @Override
    public void extract2Txt(SourceFile file) {
        Logutil.d("pdf转化为txt");
    }
}
