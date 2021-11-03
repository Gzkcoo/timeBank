package com.gzk.dao;

import com.gzk.entity.Student;

public interface StudentMapper {

    Student queryStudentByUser(String user);

}
