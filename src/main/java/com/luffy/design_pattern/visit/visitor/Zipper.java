package com.luffy.design_pattern.visit.visitor;

import com.luffy.design_pattern.opt.Logutil;
import com.luffy.design_pattern.visit.DocFile;
import com.luffy.design_pattern.visit.ExcelFile;
import com.luffy.design_pattern.visit.PdfFile;
import com.luffy.design_pattern.visit.PptFile;

/**
 * @author sunzhangfei
 * @since 2022/8/25 11:42 上午
 */
public class Zipper implements IVistor{
    @Override
    public void visit(PdfFile file) {
        //执行转换为txt操作
        Logutil.d("pfd转化为zip");
    }

    @Override
    public void visit(DocFile file) {
        //执行转换为txt操作
        Logutil.d("doc转化为zip");
    }

    @Override
    public void visit(PptFile file) {
        //执行转换为txt操作
        Logutil.d("ppt转化为zip");
    }

    @Override
    public void visit(ExcelFile file) {
        //执行转换为txt操作
        Logutil.d("excel转化为zip");
    }
}
