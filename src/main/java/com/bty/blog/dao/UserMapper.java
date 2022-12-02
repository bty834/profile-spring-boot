package com.bty.blog.dao;

import com.bty.blog.entity.User;

/**
 * @author bty
 * @date 2022/12/2
 * @since 1.8
 **/
public interface UserMapper {

    User selectUserByUsername(String username);
}
