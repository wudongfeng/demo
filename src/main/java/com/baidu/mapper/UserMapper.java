package com.baidu.mapper;

import com.baidu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wudongfeng on 17/6/2.
 */
public interface UserMapper {
    @Insert("insert into user(username,password) values(#{username},#{password})")
    public int insertUser(@Param("username")String username,@Param("password")String password);

    public int insertUserWithBackId(User User);
}
