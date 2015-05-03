package com.app.biz.module.servicelocator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liang.yaol on 5/1/15.
 */
public class AbstractServiceLocator {

    private static String        servicesLocation = "classpath:spring_services_locator.xml";

    protected static BeanFactory beanFactory;

    private static Exception     initException;

    static {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext(servicesLocation);
            beanFactory = applicationContext;
        } catch (Exception e) {
            e.printStackTrace();
            initException = e;
        }
    }

    protected static BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
