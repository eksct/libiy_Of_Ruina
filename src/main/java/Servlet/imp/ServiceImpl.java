package Servlet.imp;

import obj.Book;
import obj.Borrowing;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author g
 */
public abstract class ServiceImpl {
    public List getStudentsLimit(Integer s, Integer level) {
        return null;
    }
    public List getStudents() {
        return null;
    }
    public int insertBook(Book book) {
    return 0;
    }
    public List getBooksByName(String s) {
        return null;
    }
    public List getBooks() {
        return null;
    }
    public List getBooksLimit(int s, int level) {
        return null;
    }
    public int DeleteBook(String bid) {
    return 0;
    }
    public List getBooksUn() {return null;}
    public boolean Insert(Borrowing bs) {
        return false;
    }
    public List getBorrowings() {
        return null;
    }
    public boolean auth(String user, String pwd, HttpSession session) {return false;}
    public int Delete(String id) {return 0;}
}
