package com.luffy.design_pattern.wallet.anemic.service;

import com.luffy.design_pattern.wallet.anemic.repository.UserEntity;
import com.luffy.design_pattern.wallet.anemic.repository.UserRepository;

/**
 * @author sunzhangfei
 * @since 2021/7/27 2:54 下午
 */
public class UserService {
    private UserRepository userRepository;

    public UserBo getUserById(long id) {
        UserEntity userById = userRepository.getUserById(id);
        UserBo userBo = convertUserEntity(userById);
        return userBo;
    }

    private UserBo convertUserEntity(UserEntity userById) {
        return null;
    }
}