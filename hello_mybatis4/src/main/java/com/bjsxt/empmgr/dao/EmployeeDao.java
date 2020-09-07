package com.bjsxt.empmgr.dao;

import com.bjsxt.empmgr.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    public List<Employee> findAll();
    public Employee findById(Integer empnoId);
    //myName,myAge是自定义的,随便写
    public Employee findByMulPAram(@Param("myName") String name,@Param("myAge") Integer age);
    public int save(Employee emp);
    public int update(Employee emp);
    public void delete(Integer empno);
    public int count();
    public Map<Object,Object> findMapById(Integer id);
    public List<Employee> findAllWithResultMap();
    public List<Employee> findLikeBy(String name);
    /* 在mapper中破解like"%李%"*/
    public List<Employee> findLikeBy2(String name);
}
