package org.zhulin.mq1.common.rabbitMQ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zhulin.mq1.common.rabbitMQ.sender.MsgSender;

@RestController
public class RabbitMQController {
	@Autowired
	private MsgSender msgSender;

	@RequestMapping("/send")
	@ResponseBody
	public String sendMQ(String content) {
		msgSender.sendMsg("队列A处理消息：" + content);
		return "发送成功";
	}
	
	@RequestMapping("/sendB")
	@ResponseBody
	public String sendMQB(String content) {
		msgSender.sendMsgB("队列B处理消息：" + content);
		return "发送成功";
	}
}
