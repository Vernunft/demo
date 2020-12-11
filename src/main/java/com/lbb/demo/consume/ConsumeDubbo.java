package com.lbb.demo.consume;

import com.lbb.demo.facade.IFacade;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author lbb
 * @date 2020/12/9 9:03 下午
 */
@Component
public class ConsumeDubbo {

    @Reference(check = false, timeout = 5000)
    private IFacade facade;

    public void consume() {
        facade.testDubbo();
    }
}
