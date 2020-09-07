package org.example.test;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.test.domain.Student;
import org.example.test.mybatisUtil.MyBatisUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
//        //访问mybatis读取students数据
//        //1.定义Mybatis猪配置文件的名称,从类路径的根开始(target/classes)
//        String config="configue.xml";
//        //2.读取这个config表示的文件
//        //Resources:mybatis中的一个类,负责读取主配置文件
//        InputStream in = Resources.getResourceAsStream(config);
//        //3.创建sqlSessionFactoryBuilder对象
//        //SqlSessionFactoryBuilder:创建SqlSessionFactory对象
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        //4.创建SqlSessionFactory对象
//        /*SqlSessionFactory:重量级对象,程序创建一个对象耗时比较长,使用资源比较多,在整个项目中,创建一个就够了
//        *是一个接口,其实现类DefaultSqlSessionFactory
//        * 作用:获取SqlSession对象:SqlSession sqlSession = factory.openSession();
//        * openSession():
//        * 1.无参数:获取的是非自动提交事务的SQLSession对象
//        * 2.一个boolean参数:如果为true,获取自动提交事务的SQLSession;否则,非自动提交
//        */
//        SqlSessionFactory factory = builder.build(in);
//        //5.(重要)获取SqlSession对象,从SqlSessionFactory中获取SqlSession
//        /**
//         * SqlSession接口:定义了操作数据库的方法,例如selectOne(),selectList(),insert(),upgrade(),delete(),commit(),rollback()
//         * 其实现类:DefaultSqlSession
//         * 使用技巧:该对象不是线程安全的,需要在方法内部使用,在执行sql之前,使用openSession获取其实现类对象
//         *          在执行完sql语句后,需要关闭它,这样才能保证其实线程安全的
//         */
//        SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //6.(重要)指定要执行的sql语句的标识,sql映射文件中的namespace+"."+标签的id
        String sqlId = "org.example.test.dao.StudentDao"+"."+"findAll";
        //7.执行sql语句,通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
        studentList.forEach(stu->System.out.println(stu));
        //9.关闭sqlSession对象
        sqlSession.close();
    }
}
