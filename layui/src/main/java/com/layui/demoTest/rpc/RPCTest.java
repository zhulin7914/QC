package com.layui.demoTest.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.layui.demoTest.rpc.client.RPCClient;
import com.layui.demoTest.rpc.server.HelloService;
import com.layui.demoTest.rpc.server.HelloServiceImpl;
import com.layui.demoTest.rpc.serverCenter.Server;
import com.layui.demoTest.rpc.serverCenter.ServiceCenter;

public class RPCTest {

	public static void main(String[] args) throws IOException {
		new Thread(new Runnable() {
			public void run() {
				try {
					Server serviceServer = new ServiceCenter(8088);
					serviceServer.register(HelloService.class, HelloServiceImpl.class);
					serviceServer.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		HelloService service = RPCClient.getRemoteProxyObj(HelloService.class,
				new InetSocketAddress("localhost", 8088));
		System.out.println(service.sayHi("test"));
	}
}
