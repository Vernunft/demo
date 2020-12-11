package com.lbb.demo.service.impl;

import com.lbb.demo.entity.User;
import com.lbb.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author lbb
 * @date 2020/9/27 上午10:44
 */
@Service
public class TestImpl implements UserService {
    @Override
    public List<User> getUsers() {
        return null;
    }
}
