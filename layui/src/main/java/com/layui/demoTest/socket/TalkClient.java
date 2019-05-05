package com.layui.demoTest.socket;

import java.io.*;
import java.net.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TalkClient {

	/**
	 * 接受键盘输入的数据，通过Socket 发送给服务器端
	 */
	public static void main(String args[]) {

		log.info("客户端启动：");
		try {
			// 创建一个客户端socket，链接指定地址和端口的服务
			Socket socket = new Socket("127.0.0.1", 4700);

			// 通过Socket构建输出流对象
			PrintWriter os = new PrintWriter(socket.getOutputStream());

			// 通过Socket构建输入流对象
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 构建BufferedReader对象：键盘输入的数据
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

			// 获取字符串
			String readline = sin.readLine();

			while (!readline.equals("bye")) {

				// 发送数据
				os.println(readline);

				// 刷新
				os.flush();

				log.info("客户端发送的数据:" + readline);
				log.info("客户端接收的数据:" + is.readLine());

				// 继续获取键盘输入的数据
				readline = sin.readLine();
			}
			log.info("客户端关闭！");
			// 关闭Socket输出流
			os.close();
			// 关闭Socket输入流
			is.close();
			// 关闭Socket
			socket.close();
		} catch (Exception e) {
			log.info("Error" + e);
		}

	}

}
