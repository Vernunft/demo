package com.lbb.demo.io.test;

import java.nio.IntBuffer;

/**
 * NIO缓冲区模拟
 *
 * @author lbb
 * @date 2021/3/19 5:18 下午
 */
public class BaseBuffer {
    public static void main(String[] args) {
        // 创建一个缓冲区
        IntBuffer intBuffer = IntBuffer.allocate(5);
        // 向buffer里存放数据
//        intBuffer.put(10);
//        intBuffer.put(11);
//        intBuffer.put(12);
//        intBuffer.put(13);
//        intBuffer.put(14);
        for (int i = 0; i< intBuffer.capacity();i++) {
            intBuffer.put(i * 2);
        }

        // buffer 转换，读写切换
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }


    }
}
