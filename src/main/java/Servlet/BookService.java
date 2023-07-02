package Servlet;


import obj.Book;

import java.util.List;

/**
* @author g
* @description 针对表【book】的数据库操作Service
* @createDate 2023-05-30 12:54:11
*/
public interface BookService {
    List<Book> getBooks();

    List<Book> getBooksUn();

    Book getBookByName(String name);

    int insertBook(Book book);

    int DeleteBook(String bid);

    List<Book> getBooksLimit(int s, int l);
    List<Book> getBooksByName(String name);
}
