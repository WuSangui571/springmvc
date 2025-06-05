package com.sangui.springmvc.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-05
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;
}
