package org.zhulin.mq1.common.rabbitMQ.sender;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zhulin.mq1.common.rabbitMQ.config.RabbitConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MsgSender implements RabbitTemplate.ConfirmCallback {
  
    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;
    
    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public MsgSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }
 
    /**
     * 发送消息：交换机A→队列A
     */
    public void sendMsg(String content) {
    	//消息id
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //发送消息参数（交换机，路由键，消息，消息id）过程：生产者→(交换机→路由键→队列)→消费者
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
    }
    
    /**
     * 发送消息：交换机A→队列B
     */
    public void sendMsgB(String content) {
    	//消息id
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //发送消息参数（交换机，路由键，消息，消息id）过程：生产者→(交换机→路由键→队列)→消费者
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_B, content, correlationId);
    }
    
    /**
     * 回调，ACK消息确认
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调id:" + correlationData);
        if (ack) {
        	log.info("消息成功消费");
        } else {
        	log.info("消息消费失败:" + cause);
        }
    }
}

