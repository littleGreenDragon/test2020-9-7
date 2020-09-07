package org.example;


import com.bjsxt.empmgr.dao.EmployeeDao;
import com.bjsxt.empmgr.entity.Employee;
import com.bjsxt.empmgr.util.MybatisUtil;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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
    public void testFindByIf()
    {
        Employee employee = new Employee();
        employee.setName("胡静");
        employee.setAge(20);
        List<Employee> employeeList = dao.findByIf(employee);
        for (Employee e :
                employeeList) {
            System.out.println(e);
        }
    }
    @Test
    public void testFindByWhere()
    {
        Employee employee = new Employee();
        employee.setName("胡静");
        employee.setAge(20);
        List<Employee> employeeList = dao.findByWhere(employee);
        for (Employee e :
                employeeList) {
            System.out.println(e);
        }
    }
    @Test
    public void testFindByFor()
    {
        List<Employee> list = new ArrayList();
        Employee employee = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        employee.setId(1);
        list.add(employee);
        employee2.setId(5);
        list.add(employee2);
        employee3.setId(7);
        list.add(employee3);
//        List list = new ArrayList();
//        list.add(1);
//        list.add(5);
//        list.add(7);
//        List<Employee> employeeList = dao.findByFor(list);
        List<Employee> employeeList = dao.findByForPlus(list);
        for (Employee e :
                employeeList) {
            System.out.println(e);
        }
    }
    @Test
    public void testFindByLimit()
    {
        PageHelper.startPage(2,4);
        List<Employee> employeeList = dao.findByLimit();
        for (Employee e :
                employeeList) {
            System.out.println(e);
        }
    }
}
