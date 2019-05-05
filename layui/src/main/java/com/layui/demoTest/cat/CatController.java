package com.layui.demoTest.cat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import com.layui.dao.controller.LcgrpcontController;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/cat")
public class CatController {

	@RequestMapping("/hello")
	public String hello() {
		String pageName = "helloworld";
		String serverIp = "localhost";
		long amount = 0;
		// 下面这些指标都是独立的，可以单独使用，主要看业务场景。
		// Transaction用来记录一段程序响应时间
		Transaction t = Cat.newTransaction("URL", pageName);
		try {
			// Event用来记录一行code的执行次数
			Cat.logEvent("URL.Server", serverIp, Event.SUCCESS, "ip=" + serverIp);
			// Metric用来记录一个业务指标
			Cat.logMetricForCount("PayCount"); //用于记录一个指标值出现的次数
			Cat.logMetricForDuration("PayAmont", amount);//用于记录一个指标出现的平均值
			t.setStatus(Transaction.SUCCESS);// 设置状态
			
		} catch (Exception e) {
			e.printStackTrace();
			t.setStatus(e);// 设置错误状态
		} finally {
			t.complete();// ransaction的埋点一定要complete，切记放在finally里面。
		}
		return "home";
	}

	@RequestMapping("/hi")
	public String hi() {
		Transaction t = Cat.newTransaction("URL", "pageName");
		try {
			Cat.logEvent("URL.Server", "serverIp", Event.SUCCESS, "ip=${serverIp}");
			Cat.logMetricForCount("metric.key");
			Cat.logMetricForDuration("metric.key", 5);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception e) {
			t.setStatus(e);
			Cat.logError(e);
		} finally {
			t.complete();
		}
		return "home";
	}

}
