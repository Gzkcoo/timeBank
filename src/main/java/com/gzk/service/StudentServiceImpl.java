package com.gzk.service;

import com.gzk.dao.StudentMapper;
import com.gzk.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class StudentServiceImpl implements StudentService{

    private StudentMapper studentMapper;
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Student queryStudentByUser(String user) {
        Student student = studentMapper.queryStudentByUser(user);
        return student;
    }

}
