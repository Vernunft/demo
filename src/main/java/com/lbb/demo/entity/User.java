package com.lbb.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * @author lbb
 * @date 2020/9/4 下午2:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private Integer cityId;
    private Date createTime;
    private Integer sex;
}

