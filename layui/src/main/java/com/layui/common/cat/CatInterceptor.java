package com.layui.common.cat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Message;
import com.dianping.cat.message.Transaction;

/**
* <p>Title: CatInterceptor</p>  
* <p>Description: cat拦截器配置</p>  
* @author zhulin
* @date 2019年3月29日
 */
public class CatInterceptor implements HandlerInterceptor {

	private ThreadLocal<Transaction> tranLocal = new ThreadLocal<Transaction>();
	private ThreadLocal<Transaction> pageLocal = new ThreadLocal<Transaction>();

	/**
	 * 请求处理前拦截
	 * 预处理，可以进行编码、安全控制、权限校验等处理
	 * 处理通过返回true，否则返回false不进行处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		// Transaction用来记录一段程序响应时间
		Transaction t = Cat.newTransaction("URL", uri);
		// Event用来记录一行code的执行次数
		Cat.logEvent("URL.Method", request.getMethod(), Message.SUCCESS, request.getRequestURL().toString());
		Cat.logEvent("URL.Host", request.getMethod(), Message.SUCCESS, request.getRemoteHost());
		tranLocal.set(t);
		return true;
	}

	/**
	 * 请求处理后拦截(页面渲染前)
	 * 后处理（调用了Service并返回ModelAndView，但未进行页面渲染），
	 * 有机会修改ModelAndView （这个博主就基本不怎么用了）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		String viewName = modelAndView != null ? modelAndView.getViewName() : "null";
		Transaction t = Cat.newTransaction("View", viewName);
		pageLocal.set(t);
	}

	/**
	 * 完全处理完请求后被调用，
	 * 可用于清理资源等。返回处理（已经渲染了页面）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 请求-页面渲染前
		Transaction pt = pageLocal.get();
		pt.setStatus(Transaction.SUCCESS);
		pt.complete();

		// 总计
		Transaction t = tranLocal.get();
		t.setStatus(Transaction.SUCCESS);
		t.complete();

	}

}