package com.lbb.demo.io.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 使用transform模拟文件拷贝
 *
 * @author lbb
 * @date 2021/3/20 11:51 上午
 */
public class NIOCopy2Channel {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/qudian/Documents/20210114监控1.png");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/qudian/Documents/20210114监控1-copy.png");

        FileChannel fileInputChannel = fileInputStream.getChannel();
        FileChannel fileOutputChannel = fileOutputStream.getChannel();

        fileOutputChannel.transferFrom(fileInputChannel, 0, fileInputChannel.size());

        fileInputChannel.close();
        fileOutputChannel.close();

        fileInputStream.close();
        fileOutputStream.close();
    }
}
