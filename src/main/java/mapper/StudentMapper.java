package mapper;

import obj.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author g
* @description 针对表【student】的数据库操作Mapper
* @createDate 2023-05-30 14:24:32
*/
public interface StudentMapper {
    @Select("SELECT * FROM Student WHERE sname = #{name}")
    Student SelectStudentByName(String name);
    @Select("SELECT * FROM Student")
    List<Student> SelectStudents();
    @Select("SELECT * FROM Student limit #{s},#{end} ")
    List<Student> SelectStudentsLimit(@Param("s")Integer s,@Param("end")Integer end);
}




