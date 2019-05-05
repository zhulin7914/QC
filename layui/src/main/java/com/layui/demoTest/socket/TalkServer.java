package com.layui.demoTest.socket;

import java.io.*;
import java.net.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TalkServer {

	public static void main(String args[]) {

		log.info("服务端启动：");
		try {
			// 创建一个服务端ServerSocket，指定对外暴露端口
			ServerSocket server = new ServerSocket(4700);

			// 创建一个Socket客户端
			Socket socket = server.accept();

			// 通过Socket构建输出流对象
			PrintWriter os = new PrintWriter(socket.getOutputStream());

			// 通过Socket构建输入流对象
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 构建BufferedReader对象：键盘输入数据
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

			// 获取字符串
			String line = sin.readLine();

			while (!line.equals("bye")) {

				// 发送数据
				os.println(line);

				// 刷新
				os.flush();

				log.info("客户端发送的数据:" + line);
				log.info("客户端接收的数据:" + is.readLine());

				// 继续获取键盘输入的数据
				line = sin.readLine();

			}
			log.info("服务端关闭！");
			// 关闭Socket输出流
			os.close();
			// 关闭Socket输入流
			is.close();
			// 关闭Socket
			socket.close();
			// 关闭ServerSocket
			server.close();
		} catch (Exception e) {
			log.info("Error" + e);
		}

	}

}
