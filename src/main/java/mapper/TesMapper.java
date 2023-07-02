package mapper;


import obj.Tes;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @author g
* @description 针对表【tes】的数据库操作Mapper
* @createDate 2023-05-29 23:37:51
*/
public interface TesMapper {
    /**
     * @return Tes
     * */
    @Select("SELECT * FROM admin WHERE user = #{user} AND pwd = #{pwd}")
    Tes selectUser(@Param("user") String user, @Param("pwd") String pwd);
}




