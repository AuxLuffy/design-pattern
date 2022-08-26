package com.luffy.design_pattern.visit;

import com.luffy.design_pattern.visit.factory.ResourceFileType;
import com.luffy.design_pattern.visit.visitor.IVistor;

/**
 * @author sunzhangfei
 * @since 2022/8/24 6:31 下午
 */
public class PdfFile extends SourceFile{
    public PdfFile(String filePath) {
        super(filePath);
    }
    @Override
    public void accept(IVistor visitor) {
        visitor.visit(this);
    }

    @Override
    public ResourceFileType getFileType() {
        return ResourceFileType.PDF;
    }

//
//    @Override
//    void extract2Txt() {
//        //执行转换为txt操作
//        Logutil.d("pdf转化为txt");
//    }
}
