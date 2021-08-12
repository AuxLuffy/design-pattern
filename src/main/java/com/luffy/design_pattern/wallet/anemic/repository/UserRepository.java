package com.luffy.design_pattern.wallet.anemic.repository;

/**
 * @author sunzhangfei
 * @since 2021/7/27 2:55 下午
 */
public class UserRepository {
    public UserEntity getUserById(long id) {
        return new UserEntity();
    }
}