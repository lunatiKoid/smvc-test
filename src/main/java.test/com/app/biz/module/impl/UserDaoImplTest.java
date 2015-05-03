package com.app.biz.module.impl;

import org.junit.Before;
import org.junit.Test;

import com.app.biz.module.dataobject.UserDO;
import com.app.biz.module.factory.ConnectionFactory;
import com.app.biz.module.service.UserService;
import com.app.biz.module.service.UserServicesLocator;
import com.app.biz.module.service.impl.UserServiceImpl;

/**
 * Created by liang on 4/27/15.
 */
public class UserDaoImplTest {

    UserService userService;

    @Before
    public void before() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setDbMapperConfigLocation("spring_db_mapper_config.xml");
        connectionFactory.init();

        userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setConnectionFactory(connectionFactory);
        ((UserServiceImpl) userService).init();
    }

    @Test
    public void testFindUserById() throws Exception {

        UserDO userDO = userService.findUserById(3);
        if (userDO != null) {
            System.out.println(userDO.toString());
        } else {
            System.out.println("error");
        }
    }

    @org.junit.Test
    public void testInsertUser() throws Exception {
        UserDO userDO = new UserDO();
        userDO.setId(99);
        userDO.setName("Yao");
        userDO.setAge(99);

        userService.insertUser(userDO);

        UserDO userDOFind = userService.findUserById(99);
        if (userDOFind != null) {
            System.out.println(userDOFind.toString());
        }
    }

    @Test
    public void testServiceLocator() {
        UserService userService = UserServicesLocator.getUserService();
        UserDO userDO = userService.findUserById(3);
        if (userDO != null) {
            System.out.println(userDO.toString());
        } else {
            System.out.println("error");
        }
    }
}
