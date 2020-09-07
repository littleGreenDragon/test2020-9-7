package com.bjsxt.empmgr.dao;

import com.bjsxt.empmgr.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    //动态sql得使用java对象最为参数
    List<Employee> findByIf(Employee e);
    List<Employee> findByWhere(Employee e);
    List<Employee> findByFor(List e);
    List<Employee> findByForPlus(List<Employee> e);
    List<Employee> findByLimit();
}
