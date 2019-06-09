package cn.e3mall.dubbo;

import cn.e3mall.dubboService.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DubboConsumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"dubbo/dubbo-consumer.xml"});
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");
        String hello = demoService.sayHello("hejingyuan");
        System.out.println(hello);

        List list = demoService.getUsers();
        if (list != null && list.size() > 0) {
            System.out.println("已经进来了！");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("测试："+i);
                System.out.println(list.get(i));
            }
        }
        System.in.read();
    }
}
