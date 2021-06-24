package com.lbb.demo.controller;

import com.lbb.demo.dao.AddressMapper;
import com.lbb.demo.entity.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author lbb
 * @date 2021/6/23 8:11 下午
 */
@RestController
public class AddressController {

    @Resource
    private AddressMapper addressMapper;

    @PostMapping("/address/save")
    public String save() {
        for (int i = 0; i < 10; i++) {
            Address address = new Address();
            address.setCode("code_" + i);
            address.setName("name_" + i);
            address.setPid(i + "");
            address.setType(0);
            address.setLit(i % 2 == 0 ? 1 : 2);
            addressMapper.save(address);
        }

        return "success";
    }

    @GetMapping("/address/get/{id}")
    public Address get(@PathVariable Long id) {
        return addressMapper.get(id);
    }

}

