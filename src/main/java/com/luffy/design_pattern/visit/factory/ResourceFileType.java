package com.luffy.design_pattern.visit.factory;

/**
 * @author sunzhangfei
 * @since 2022/8/25 11:50 上午
 */
public enum ResourceFileType {
    PDF("pdf"), DOC("doc"), EXCEL("xls"), PPT("ppt");

    private final String extention;

    ResourceFileType(String extention) {
        this.extention = extention;
    }

    public String getExtention() {
        return extention;
    }
}
