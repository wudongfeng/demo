package com.baidu;

import com.baidu.domain.User;
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
    public void testMessage(){

    }

}
