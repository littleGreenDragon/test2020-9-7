package org.example;


import com.bjsxt.empmgr.dao.EmployeeDao;
import com.bjsxt.empmgr.entity.Employee;
import com.bjsxt.empmgr.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class TestMyClass {
    /**
     * 使用mybatis的动态代理机制,使用sqlsession.getMapper(dao接口)
     * getterMapper能获取dao接口对于的实现类对象
     */
    SqlSession sqlSession = MybatisUtil.getSqlSession();
    EmployeeDao dao = sqlSession.getMapper(EmployeeDao.class);
    @Test
    public void testFindAll()
    {
        List<Employee> employeeList = dao.findAll();
        employeeList.forEach(employee -> System.out.println(employee));
    }
        @Test
        public void testSave()
        {
            Employee employee = new Employee(
                    20,"艾胡","女",20,
                    "987657655@qq.com",
                    "12276652344",
                    "江西省南昌市",new Date(2020,8,13),
                    "programmer",8000);
            int number = dao.save(employee);
            sqlSession.commit();
            System.out.println("添加"+number);
        }
    @Test
    public void testFindById()
    {
        Employee employee = dao.findById(10);
        System.out.println(employee);
    }
    @Test
    public void testFindByMulParam()
    {
        Employee employee = dao.findByMulPAram("谢英",22);
        System.out.println(employee);
    }
    @Test
    public void testCount()
    {
        System.out.println(dao.count());
    }
        @Test
        public void testFindMapById()
        {
            Map<Object,Object> map = dao.findMapById(3);
            System.out.println(map.get("name"));
            System.out.println(map);
        }
        @Test
        public void testFindAllWithResultMap()
        {
           List<Employee> employeeList = dao.findAllWithResultMap();
            employeeList.forEach(employee -> System.out.println(employee));
        }
    @Test
    public void testFindLike()
    {
        List<Employee> employeeList = dao.findLikeBy("胡%");
        for (Employee employee:employeeList) {
            System.out.println(employee);
        }
    }
    @Test
    public void testFindLike2()
    {
        List<Employee> employeeList = dao.findLikeBy2("胡");
        for (Employee employee:employeeList) {
            System.out.println(employee);
        }
    }
}
