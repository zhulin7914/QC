package com.layui.common.rabbitMQ.receiver;

import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.layui.common.other.JsonUtil;
import com.layui.common.rabbitMQ.config.RabbitConfig;
import com.layui.common.redis.util.RedisUtilHash;
import com.layui.dao.entity.User;
import com.layui.dao.service.IUserService;
import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;

/**
 * 比如一个生产者，多个消费者，可以写多个消费者，并且他们的分发是负载均衡的。
 * 使用ACK消息确认
 */
@Slf4j
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_B)//监听的队列B
public class MsgReceiverB {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private RedisUtilHash redisUtilHash;
 
    @RabbitHandler
    public void process(String content,Channel channel, Message message) throws IOException {
    	log.info("消费者B：接收处理队列B当中的消息： " + content);
        try {
        	//获取redis里面的数据，将其存入数据库
        	if (!StringUtils.isEmpty(content)){
        		String str;
        		User user=new User();
        		if("a1".equals(content)) {
            		str = (String) redisTemplate.opsForValue().get(content);
            		user=(User)JsonUtil.parse(str, User.class);
        		}else if("a2".equals(content)) {
        			Map<String, String> stumap=redisUtilHash.hgetall(content);
        			str =JsonUtil.generate(stumap);
            		user=(User)JsonUtil.parse(str, User.class);
        		}
        		log.info("用户信息："+user.toString());
        		userService.addUser(user);
        		log.info("新增用户成功！");
        	}
        	//确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            log.info("收取消息成功！");
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
            log.info("收取消息失败！");
        }
    }

}
