package com.luffy.design_pattern.visit.visitor;

import com.luffy.design_pattern.visit.DocFile;
import com.luffy.design_pattern.visit.ExcelFile;
import com.luffy.design_pattern.visit.PdfFile;
import com.luffy.design_pattern.visit.PptFile;

/**
 * @author sunzhangfei
 * @since 2022/8/25 11:38 上午
 */
public interface IVistor {
    void visit(PdfFile file);

    void visit(DocFile file);

    void visit(PptFile file);

    void visit(ExcelFile file);
}
