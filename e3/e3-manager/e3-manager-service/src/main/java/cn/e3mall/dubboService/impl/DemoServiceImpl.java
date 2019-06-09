package cn.e3mall.dubboService.impl;

import cn.e3mall.dubboService.DemoService;
import cn.e3mall.pojo.User;

import java.util.ArrayList;
import java.util.List;


public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "Hello " + name;
    }

    public List getUsers() {
        List list = new ArrayList();
        User u1 = new User();
        u1.setId("1");
        u1.setUserName("xxx");
        u1.setPassWord("123");

        User u2 = new User();
        u2.setId("2");
        u2.setUserName("haha");
        u2.setPassWord("456");


        list.add(u1);
        list.add(u2);

        return list;
    }
}
