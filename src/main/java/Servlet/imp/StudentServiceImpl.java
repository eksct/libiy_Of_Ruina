package Servlet.imp;

import obj.Student;
import Servlet.StudentService;
import mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import Util.Util;

import java.util.List;

/**
* @author g
* @description 针对表【student】的数据库操作Service实现
* @createDate 2023-05-30 14:24:32
*/
public class StudentServiceImpl extends ServiceImpl implements StudentService{
    @Override
    public Student getStudent(String name){
       try(SqlSession session = Util.mysqlConnection(true)){
           return session.getMapper(StudentMapper.class).SelectStudentByName(name);
       }
    }

    /**
     * @return
     */
    @Override
    public List<Student> getStudents() {
        try(SqlSession session = Util.mysqlConnection(true)){
            return session.getMapper(StudentMapper.class).SelectStudents();
        }
    }

    /**
     * @param s
     * @param end
     * @return
     */
    @Override
    public List<Student> getStudentsLimit(Integer s, Integer end) {
        try(SqlSession session = Util.mysqlConnection(true)){
            return session.getMapper(StudentMapper.class).SelectStudentsLimit(s, end);
        }
    }
}




