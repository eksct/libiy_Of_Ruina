package mapper;

import obj.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author g
* @description 针对表【book】的数据库操作Mapper
* @createDate 2023-05-30 12:56:31
* @Entity generator.domain.Book
*/
public interface BookMapper {
    @Select("SELECT * FROM book")
    List<Book> selectBooks();
    @Select("SELECT * FROM book WHERE Bid NOT IN (SELECT BobId FROM borrowing)")
    List<Book> selectBookUn();
    @Select("SELECT * FROM book WHERE bname = #{name}")
    Book selectedBookByName(String name);
    @Insert("INSERT INTO book values (#{bid},#{bname},#{author},#{price})")
    int insertBook(Book book);
    @Delete("DELETE FROM book WHERE Bid=#{bid}")
    int deleteBook(String bid);
    @Select("SELECT * FROM book LIMIT #{S},#{L}")
    List<Book> selectBookLimit(@Param("S") int stand,@Param("L") int limit);
    @Select("SELECT * FROM book WHERE bname LIKE #{name}")
    List<Book> selectBooksByName(String name);
}




