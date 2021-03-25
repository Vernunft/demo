package com.lbb.demo.io.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * telnet次端口便可以模拟
 *
 * @author lbb
 * @date 2021/3/19 2:57 下午
 */
public class BIOTest {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器端启动了");
        while (true) {
            System.out.println("线程信息id：" + Thread.currentThread().getId() + ",名字是：" + Thread.currentThread().getName());
            System.out.println("监听，等待连接。。。");
            Socket socket = serverSocket.accept();
            System.out.println("收到一个连接");
            // 就创建一个线程与之通信
            executorService.execute(() -> {
                handlerSocket(socket);
            });
        }


    }

    private static void handlerSocket(Socket socket) {
        try {
            System.out.println("线程信息id：" + Thread.currentThread().getId() + ",名字是：" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            // 开始读取客户端信息
            while (true) {
                System.out.println("线程信息id：" + Thread.currentThread().getId() + ",名字是：" + Thread.currentThread().getName());
                System.out.println("read。。");
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭客户端连接
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
