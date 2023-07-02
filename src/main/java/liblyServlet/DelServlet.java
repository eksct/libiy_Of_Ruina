package liblyServlet;

import Servlet.imp.BookServiceImpl;
import Servlet.imp.BorrowingServiceImpl;
import Servlet.imp.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/del")
public class DelServlet extends HttpServlet {
    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    ServiceImpl bookService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id")==null){
            System.out.println(req.getParameter("bid"));
            bookService.DeleteBook(req.getParameter("bid"));
            resp.sendRedirect("book");
        }else {
            service.Delete(req.getParameter("id"));
            resp.sendRedirect("index");
        }

    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    /**
     * @throws ServletException
     */
    ServiceImpl service;
    @Override
    public void init() throws ServletException {
        service  = new BorrowingServiceImpl();
        bookService = new BookServiceImpl();
    }
}
