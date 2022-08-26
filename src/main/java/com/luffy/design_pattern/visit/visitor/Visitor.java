package com.luffy.design_pattern.visit.visitor;

import com.luffy.design_pattern.opt.Logutil;
import com.luffy.design_pattern.visit.DocFile;
import com.luffy.design_pattern.visit.ExcelFile;
import com.luffy.design_pattern.visit.PdfFile;
import com.luffy.design_pattern.visit.PptFile;

/**
 * @author sunzhangfei
 * @since 2022/8/25 11:26 上午
 */
public class Visitor {
    public void extract2Txt(DocFile file){
        //执行转换为txt操作
        Logutil.d("doc转化为txt");
    }
    public void extract2Txt(PdfFile file){
        //执行转换为txt操作
        Logutil.d("pdf转化为txt");
    }
    public void extract2Txt(ExcelFile file){
        //执行转换为txt操作
        Logutil.d("excel转化为txt");
    }
    public void extract2Txt(PptFile file){
        //执行转换为txt操作
        Logutil.d("ppt转化为txt");
    }
    public void zip(DocFile file){
        //执行转换为txt操作
        Logutil.d("doc转化为zip");
    }
    public void zip(PdfFile file){
        //执行转换为txt操作
        Logutil.d("pdf转化为zip");
    }
    public void zip(ExcelFile file){
        //执行转换为txt操作
        Logutil.d("excel转化为zip");
    }
    public void zip(PptFile file){
        //执行转换为txt操作
        Logutil.d("ppt转化为zip");
    }
}
