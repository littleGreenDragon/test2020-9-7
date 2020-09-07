package com.bjsxt.empmgr.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtil {
    private static SqlSessionFactory factory;
    static {
        String config="configue.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            System.out.println("加载配置出问题");
        }
    }
    //获取SqlSession
    public static SqlSession getSqlSession()
    {
        SqlSession sqlSession = null;
        if(factory != null)
        {
            sqlSession = factory.openSession();//非自动提交事务
        }
        return sqlSession;
    }
}
