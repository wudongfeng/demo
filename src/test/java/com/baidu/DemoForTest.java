package com.baidu;

import com.baidu.constants.ApiKey;
import com.baidu.domain.User;
import com.baidu.util.TokenUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wudongfeng on 17/6/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoForTest {
    @Test
    public void testHashMap(){
        Map<String,User> usermap=new HashMap<>();
        User user=new User();
        user.setUsername("wdf");
        user.setPassword("1989");
        usermap.put(user.getUsername(),user);
        System.out.println("the output:"+Map.Entry.class);
    }

    @Test
    public void testJWT(){
        String id="wdf";
        String issuer="baidu";
        String subject="com";
        long ttlMillis=1993984994;
        String key=TokenUtils.createJWT(id,issuer,subject,ttlMillis);
        System.out.println("-----this is to secret-----");
        System.out.println(key);
        System.out.println();
        System.out.println("-----this is pares---------");
        TokenUtils.parseJWT(key);


    }

}
