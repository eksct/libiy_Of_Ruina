package Servlet;

import obj.Student;

import java.util.List;

/**
* @author g
* @description 针对表【student】的数据库操作Service
* @createDate 2023-05-30 14:24:32
*/
public interface StudentService {

    Student getStudent(String name);
    List<Student> getStudents();
    List<Student> getStudentsLimit(Integer s,Integer end);
}
