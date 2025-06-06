package com.sangui.springmvc.service;


import com.sangui.springmvc.pojo.User;

import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-06
 * @Description:
 * @Version: 1.0
 */
public interface UserService {
    User selectOne(Long id);
    List<User> selectAll();

    int saveUser(User user);

    int deleteUser(Long id);

    int updateUser(User user);
}
