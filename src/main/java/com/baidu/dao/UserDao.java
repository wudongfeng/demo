package com.baidu.dao;

import com.baidu.domain.User;
import com.baidu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wudongfeng on 17/6/2.
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;
    public int insertUser(String username, String password){
        return userMapper.insertUser(username, password);
    }

    public int insertUserWithBackId(User user){
        return userMapper.insertUserWithBackId(user);
    }


}
