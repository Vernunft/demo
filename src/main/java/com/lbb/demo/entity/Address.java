package com.lbb.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lbb
 * @date 2021/6/23 8:06 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    private Long id;
    private String code;
    private String name;
    private String pid;
    private Integer type;
    private Integer lit;
}
