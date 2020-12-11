package com.lbb.demo.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lbb
 * @date 2020/9/27 上午10:10
 */
@Slf4j
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static Object getBeanByName(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    public static <T> T getBeanOfType(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBeanByName(String beanName, Class<T> beanClass) {
        if (applicationContext.containsBean(beanName)) {
            return applicationContext.getBean(beanName, beanClass);
        }
        return null;
    }

    public static boolean containsBean(String beanName) {
        return applicationContext.containsBean(beanName);
    }
}