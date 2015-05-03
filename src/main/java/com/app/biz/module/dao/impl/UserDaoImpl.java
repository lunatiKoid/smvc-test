package com.app.biz.module.dao.impl;

import com.app.biz.module.dao.UserDao;
import com.app.biz.module.dataobject.UserDO;
import com.app.biz.module.factory.ConnectionFactory;

/**
 * Created by liang on 4/27/15.
 *
 * 这个类，到底需不需要... 从现在的角度应该是不需要。
 *
 */
public class UserDaoImpl implements UserDao {

    @Override
    public Integer findMaxId() {
        return null;
    }

    @Override
    public UserDO findUserByName(String name) {
        return null;
    }

    public UserDO findUserById(Integer id) {
        return null;
    }

    public int insertUser(UserDO userDO) {
        return 0;
    }
}
