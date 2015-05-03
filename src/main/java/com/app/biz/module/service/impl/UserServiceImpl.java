package com.app.biz.module.service.impl;

import com.app.biz.module.dao.UserDao;
import com.app.biz.module.dataobject.UserDO;
import com.app.biz.module.factory.ConnectionFactory;
import com.app.biz.module.service.UserService;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by liang on 4/27/15.
 */
public class UserServiceImpl implements UserService {

    private ConnectionFactory connectionFactory;
    private SqlSession        sqlSession;

    private UserDao           dao;

    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void init() {
        sqlSession = connectionFactory.getSqlSessionFactory().openSession();
        dao = sqlSession.getMapper(UserDao.class);
    }

    public void destroy() {
        sqlSession.close();
    }

    public UserDO findUserByName(String name) {
        return dao.findUserByName(name);
    }

    public UserDO findUserById(Integer id) {
        return dao.findUserById(id);
    }

    public int findMaxId() {
        return dao.findMaxId();
    }

    public int insertUser(UserDO userDO) {
        int ret = dao.insertUser(userDO);
        sqlSession.commit();
        return ret;
    }
}
