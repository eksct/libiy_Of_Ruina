package Servlet.imp;


import Servlet.BookService;
import Util.Util;
import mapper.BookMapper;
import obj.Book;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


/**
* @author g
* @description 针对表【book】的数据库操作Service实现
* @createDate 2023-05-30 12:54:11
*/

public class BookServiceImpl extends ServiceImpl implements BookService{

    @Override
    public List<Book> getBooks() {
        try(SqlSession session = Util.mysqlConnection(true)){
            return session.getMapper(BookMapper.class).selectBooks();
        }
    }

    /**
     * @return
     */
    @Override
    public List<Book> getBooksUn() {
        try(SqlSession session = Util.mysqlConnection(true)){
            return session.getMapper(BookMapper.class).selectBookUn();
        }
    }

    /**
     * @param name
     * @return
     */
    @Override
    public Book getBookByName(String name) {
        try (SqlSession session = Util.mysqlConnection(true)){
            return session.getMapper(BookMapper.class).selectedBookByName(name);
        }
    }

    /**
     * @param book
     * @return
     */
    @Override
    public int insertBook(Book book) {
       try(SqlSession session = Util.mysqlConnection(true)) {
           return session.getMapper(BookMapper.class).insertBook(book);
       }
    }

    /**
     * @param bid
     * @return
     */
    @Override
    public int DeleteBook(String bid) {
        try(SqlSession session = Util.mysqlConnection(true)){
            return session.getMapper(BookMapper.class).deleteBook(bid);
        }
    }

    /**
     * @return
     */
    @Override
    public List<Book> getBooksLimit(int s,int l) {
        try(SqlSession session = Util.mysqlConnection(true)){
            return session.getMapper(BookMapper.class).selectBookLimit(s,l);
        }
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<Book> getBooksByName(String name) {
       try(SqlSession session = Util.mysqlConnection(true)){
           return session.getMapper(BookMapper.class).selectBooksByName(name);
       }
    }
}




