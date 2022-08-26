package com.luffy.design_pattern.visit;

import com.luffy.design_pattern.visit.factory.ResourceFileType;
import com.luffy.design_pattern.visit.visitor.IVistor;

/**
 * @author sunzhangfei
 * @since 2022/8/24 6:59 下午
 */
public class ExcelFile extends SourceFile {
    public ExcelFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(IVistor visitor) {
        visitor.visit(this);
    }
    @Override
    public ResourceFileType getFileType() {
        return ResourceFileType.EXCEL;
    }

//
//    @Override
//    void extract2Txt() {
//        //执行转换为txt操作
//        Logutil.d("excel转化为txt");
//    }
}
