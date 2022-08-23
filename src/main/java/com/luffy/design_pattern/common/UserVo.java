package com.luffy.design_pattern.common;

/**
 * @author sunzhangfei
 * @since 2021/7/27 2:53 下午
 */
public class UserVo {
    private long id;
    private String name;

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    private String cellphone;

    public UserVo(String cellphone) {
        this.cellphone = cellphone;
    }

    public UserVo(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public UserVo(String phone, String name) {
        this.cellphone = phone;
        this.name = name;
    }

    public UserVo(long id, String name, String cellphone) {
        this.id = id;
        this.name = name;
        this.cellphone = cellphone;
    }

    public UserVo(long id) {
        this.id = id;
    }

    public UserVo() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }

    public String getCellPhone() {
        return cellphone;
    }

    public void setId(long id) {
        this.id = id;
    }
}