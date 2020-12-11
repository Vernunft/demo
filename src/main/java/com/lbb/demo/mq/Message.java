package com.lbb.demo.mq;

import lombok.Builder;
import lombok.Data;

/**
 * @author lbb
 * @date 2020/9/4 下午4:09
 */
@Data
@Builder
public class Message {

    private String id;

    private String message;
}
