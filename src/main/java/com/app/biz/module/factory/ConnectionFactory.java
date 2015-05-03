package com.app.biz.module.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by liang on 4/27/15.
 */
public class ConnectionFactory {

    private SqlSessionFactory sqlSessionFactory;
    private String            dbMapperConfigLocation;   // "spring_db_mapper_config.xml"

    public void setDbMapperConfigLocation(String dbMapperConfigLocation) {
        this.dbMapperConfigLocation = dbMapperConfigLocation;
    }

    public void init() {
        try {
            Reader reader = Resources.getResourceAsReader(dbMapperConfigLocation);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
