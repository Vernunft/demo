package com.lbb.demo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 模拟缓冲池和通道读取文件
 *
 * @author lbb
 * @date 2021/3/20 11:16 上午
 */
public class NIOReadFileChannel {

    public static void main(String[] args) throws IOException {
        // 创建文件的输入流
        File file = new File("/Users/qudian/Documents/code/demo/nio1.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        // 通过输入流获取对应的通道
        FileChannel fileChannel = fileInputStream.getChannel();

        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());

        // 将通道的数据读入到缓冲区
        fileChannel.read(byteBuffer);

        // 将byteBuffer的字节数据专程string
        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();

    }


}
