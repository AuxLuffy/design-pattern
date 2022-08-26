package com.luffy.design_pattern.visit.factory.zip;

import com.luffy.design_pattern.opt.Logutil;
import com.luffy.design_pattern.visit.SourceFile;

/**
 * @author sunzhangfei
 * @since 2022/8/25 2:16 下午
 */
public class ExcelZipper implements IZip{
    @Override
    public void zip(SourceFile file) {
        Logutil.d("excel转化为zip");
    }
}
