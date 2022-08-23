package com.luffy.design_pattern.common;

/**
 * 用户操作接口
 *
 * @author sunzhangfei
 * @since 2022/5/6 3:46 下午
 */
public interface IUserController {
    UserVo login(String phone, String password);
    UserVo register(String phone, String password);
}