package com.bjsxt.empmgr.dao;

import com.bjsxt.empmgr.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List findAll();
    public Employee findById(int empno);
    public int save(Employee emp);
    public int update(Employee emp);
    public void delete(int empno);
}
