package org.example;


import com.bjsxt.empmgr.dao.EmployeeDao;
import com.bjsxt.empmgr.dao.impl.EmployeeDaoImpl;
import com.bjsxt.empmgr.entity.Employee;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.List;

public class TestMyClass {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Test
    public void testFindAll()
    {
        List<Employee> employeeList = employeeDao.findAll();
        employeeList.forEach(employee -> System.out.println(employee));
    }
    @Test
    public void testSave()
    {
        Employee employee = new Employee(
                12,"李婷","女",20,
                "277887655@qq.com",
                "12276652344",
                "四川省内江市","2020-8-13",
                "programmer",8000);
        int number = employeeDao.save(employee);
        System.out.println("添加"+number);
    }
}
