package com.bjsxt.empmgr.dao.impl;

import com.bjsxt.empmgr.dao.EmployeeDao;
import com.bjsxt.empmgr.entity.Employee;
import com.bjsxt.empmgr.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    SqlSession sqlSession = DBUtil.getSqlSession();
    @Override
    public List findAll() {
        String sqlId = "com.bjsxt.empmgr.dao.EmployeeDao.findAll";
        List<Employee> employeeList = sqlSession.selectList(sqlId);
        sqlSession.close();
        return employeeList;
    }

    @Override
    public Employee findById(int empno) {
        return null;
    }

    @Override
    public int save(Employee emp) {
        String sqlId = "com.bjsxt.empmgr.dao.EmployeeDao.save";
        int number = sqlSession.insert(sqlId,emp);
        sqlSession.commit();
        sqlSession.close();
        return number;
    }

    @Override
    public int update(Employee emp) {
        return 0;
    }

    @Override
    public void delete(int empno) {

    }
}
