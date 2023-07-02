package Servlet;


import obj.Borrowing;

import java.util.List;

/**
* @author g
* @description 针对表【borrowing】的数据库操作Service
* @createDate 2023-05-30 12:06:54
*/
public interface BorrowingService {
        List<Borrowing> getBorrowings();
        boolean Insert (Borrowing bor);
        int Delete (String id);
}
