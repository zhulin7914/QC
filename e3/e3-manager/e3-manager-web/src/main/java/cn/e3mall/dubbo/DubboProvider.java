package cn.e3mall.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboProvider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"dubbo/dubbo-provider.xml"});
        context.start();
        System.out.println("dubbo服务方已经启动");
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟，按任意键退出
    }
}