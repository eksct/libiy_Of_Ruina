package mapper;


import obj.Borrowing;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
* @author g
* @description 针对表【borrowing】的数据库操作Mapper
* @createDate 2023-05-30 12:06:54
*/
public interface BorrowingMapper  {

    @Results({
            @Result(column = "bosid",property = "bosid"),
            @Result(column = "bobid",property = "bobid"),
            @Result(column = "time",property = "time"),
            @Result(column = "bName",property = "bookName"),
            @Result(column = "sName",property = "studentName"),
    })
    @Select("SELECT  * FROM borrowing " +
            "INNER JOIN student s " +
            "on borrowing.bosId = s.sid " +
            "Inner JOIN book b " +
            "on borrowing.BobId = b.Bid")
    List<Borrowing> selectBorrowing();
    @Insert("INSERT INTO borrowing(bosId, BobId, time) values(#{bosid},#{bobid},#{time})")
    int INSERT(Borrowing bor);
    @Delete("DELETE FROM borrowing WHERE BobId =#{id}")
    int DELETE(String id);

}




