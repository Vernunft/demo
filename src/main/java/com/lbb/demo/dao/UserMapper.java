package com.lbb.demo.dao;

import com.lbb.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author lbb
 * @date 2020/9/4 下午2:31
 */
@Mapper
public interface UserMapper {
    /**
     * 保存
     */
    @Insert("INSERT INTO t_user(name,phone,email,city_id,sex,password) VALUES(#{name},#{phone},#{email}," +
            "#{cityId}," +
            "#{sex},#{password})")
    void save(User user);

    /**
     * 查询
     * @param id
     * @return
     */
    @Select("select * from t_user where id = #{id}")
    User get(Long id);

    @Select("select * from t_user")
    List<User> getUsers();
}

