package com.lbb.demo.dao;

import com.lbb.demo.entity.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author lbb
 * @date 2021/6/23 8:08 下午
 */
@Mapper
public interface AddressMapper {
    /**
     * 保存
     */
    @Insert("INSERT INTO t_address(code,name,pid,type,lit) VALUES(#{code},#{name},#{pid},#{type},#{lit})")
    void save(Address address);

    /**
     * 查询
     * @param id
     * @return
     */
    @Select("select * from t_address where id = #{id}")
    Address get(Long id);
}
