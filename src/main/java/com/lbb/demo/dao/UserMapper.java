package com.lbb.demo.dao;

import com.lbb.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author lbb
 * @date 2020/9/4 下午2:31
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();
}
