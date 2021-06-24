package com.lbb.demo.service.impl;

import com.lbb.demo.dao.UserMapper;
import com.lbb.demo.entity.User;
import com.lbb.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;

/**
 * @author lbb
 * @date 2020/9/4 下午2:33
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Override
    public List<User> getUsers() {
      return userMapper.getUsers();
    }
}
