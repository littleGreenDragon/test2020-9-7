package org.example;


import com.bjsxt.empmgr.dao.EmployeeDao;
import com.bjsxt.empmgr.entity.Employee;
import com.bjsxt.empmgr.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyClass {
    /**
     * 使用mybatis的动态代理机制,使用sqlsession.getMapper(dao接口)
     * getterMapper能获取dao接口对于的实现类对象
     */
    SqlSession sqlSession = DBUtil.getSqlSession();
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
                14,"胡静","女",20,
                "987657655@qq.com",
                "12276652344",
                "江西省南昌市","2020-8-13",
                "programmer",8000);
        int number = dao.save(employee);
        sqlSession.commit();
        System.out.println("添加"+number);
    }
}
