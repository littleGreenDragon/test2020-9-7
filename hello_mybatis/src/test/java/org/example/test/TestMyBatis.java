package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.test.domain.Student;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    @Test
    public void testSave() throws IOException {
        //访问mybatis读取students数据
        //1.定义Mybatis猪配置文件的名称,从类路径的根开始(target/classes)
        String config="configue.xml";
        //2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.(重要)获取SqlSession对象,从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //6.(重要)指定要执行的sql语句的标识,sql映射文件中的namespace+"."+标签的id
        String sqlId  = "org.example.test.dao.StudentDao"+"."+"save";
        //7.执行sql语句,通过sqlId找到语句
        Student student = new Student(3,"罗小黑",200);
        int number = sqlSession.insert(sqlId,student);
        //mybatis默认不自动提交事务,所以在增删改之后要手工提交事务
        sqlSession.commit();
        //8.输出结果
        System.out.println("插入"+number+"条");
        //9.关闭sqlSession对象
        sqlSession.close();
    }
}
