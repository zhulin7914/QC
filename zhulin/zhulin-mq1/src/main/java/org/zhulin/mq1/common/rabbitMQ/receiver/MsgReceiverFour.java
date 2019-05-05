package org.zhulin.mq1.common.rabbitMQ.receiver;

import java.io.IOException;
import java.util.Date;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.zhulin.mq1.common.rabbitMQ.config.RabbitConfig;

import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;

/**
 * 比如一个生产者，多个消费者，可以写多个消费者，并且他们的分发是负载均衡的。
 * 使用ACK消息确认
 */
@Slf4j
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)//监听的队列A
public class MsgReceiverFour {
 
    @RabbitHandler
    public void process(String content,Channel channel, Message message) throws IOException {
    	log.info("消费者four：接收处理队列A当中的消息： " + content+"收到时间"+new Date());
        try {
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("收取消息成功！");
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            log.info("收取消息失败！");
        }
    }
    
//  //消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息
//    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//
//    //ack返回false，并重新回到队列，api里面解释得很清楚
//    channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
//
//    //拒绝消息
//    channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
}
