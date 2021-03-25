package com.lbb.demo.io.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 模拟文件拷贝
 *
 * @author lbb
 * @date 2021/3/20 11:37 上午
 */
public class NIOCopyChannel {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/qudian/Documents/code/demo/nio1.txt");
        FileChannel fileChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/qudian/Documents/code/demo/nio-copy1.txt");
        FileChannel fileCopyChnanel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            byteBuffer.clear();
            int read = fileChannel.read(byteBuffer);
            System.out.println("read=" + read);
            // 重复读取，直到读取完成，退出
            if (read == -1) {
                break;
            }
            byteBuffer.flip();

            fileCopyChnanel.write(byteBuffer);

        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
