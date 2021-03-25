package com.lbb.demo.io.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 模拟通道和缓冲写文件
 *
 * @author lbb
 * @date 2021/3/20 10:46 上午
 */
public class NIOWriteFileChannel {

    public static void main(String[] args) throws IOException {
        String str = "hello，girls";
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/qudian/Documents/code/demo/nio1.txt");

        // 通过文件流获取对应的fileChannel
        FileChannel fileChannel = fileOutputStream.getChannel();

        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 将str放入buffer中
        byteBuffer.put(str.getBytes());
        // 对byteBuffer进行flip
        byteBuffer.flip();

        // 将byteBuffer数据写入fileChannel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();;
    }
}
