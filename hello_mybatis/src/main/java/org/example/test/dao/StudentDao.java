package org.example.test.dao;

import org.example.test.domain.Student;

import java.util.List;

//接口操作student表
public interface StudentDao {
    //查看student表的所有数据
    public List<Student> findAll();
    //通过id查找
    public Student findById(int stu);
    //增加一个学生
    public int save(Student stu);
    //更新数据
    public int update(Student stu);
    //删除学生
    public void delete(int stuId);
}
