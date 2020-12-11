package com.lbb.demo.facade.impl;

import com.lbb.demo.facade.IFacade;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author lbb
 * @date 2020/12/9 8:56 下午
 */
@Service
public class FacadeImpl implements IFacade {
    @Override
    public void testDubbo() {
        System.out.println("dubbo提供服务");
    }
}
