package com.layui.common.rabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
* <p>Title: RabbitConfig</p>  
* <p>Description: rabbitMQ配置类，设置交换机、路由键、队列，链接rabbitMQ</p>  
* @author zhulin
* @date 2019年4月4日
 */
@Configuration
public class RabbitConfig {
 
    @Value("${spring.rabbitmq.host}")
    private String host;
 
    @Value("${spring.rabbitmq.port}")
    private int port;
 
    @Value("${spring.rabbitmq.username}")
    private String username;
 
    @Value("${spring.rabbitmq.password}")
    private String password;
 
    //交换机
    public static final String EXCHANGE_A = "exchange_A";
    public static final String EXCHANGE_B = "exchange_B";
    public static final String EXCHANGE_C = "exchange_C";
 
    //队列
    public static final String QUEUE_A = "queue_a";
    public static final String QUEUE_B = "queue_b";
    public static final String QUEUE_C = "queue_c";
 
    //路由键：连接交换机与队列
    public static final String ROUTINGKEY_A = "routingKey_A";
    public static final String ROUTINGKEY_B = "routingKey_B";
    public static final String ROUTINGKEY_C = "routingKey_C";
 
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }
 
    @Bean
    @Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)//这个是说在每次注入的时候回自动创建一个新的bean实例
    //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }
    
    /**
     * 交换机配置，可以配置多个
     */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(EXCHANGE_A);
    }
    
    /**
     * 队列配置  可以配置多个队列
     */
    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A, true); //队列持久
    }

    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_B, true); //队列持久
    }
    
    /**
     * 通过路由键将消息队列和交换机进行绑定
     * 交换机A→通过理由键A→绑定队列A
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queueA()).to(defaultExchange()).with(RabbitConfig.ROUTINGKEY_A);
    }
    
    //一个交换机可以绑定多个消息队列，也就是消息通过一个交换机，可以分发到不同的队列当中去。
    
    /**
     * 通过路由键将消息队列和交换机进行绑定
     * 交换机A→通过理由键B→绑定队列B  
     */
    @Bean
    public Binding bindingB(){
        return BindingBuilder.bind(queueB()).to(defaultExchange()).with(RabbitConfig.ROUTINGKEY_B);
    }

}
