package liblyServlet;

import Servlet.BookService;
import Servlet.imp.BookServiceImpl;
import Servlet.imp.ServiceImpl;
import Util.Util;
import obj.Book;
import obj.Tes;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lks")
public class addBook extends HttpServlet {
    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Util.adduc(resp,req,user,context);
        Util.process("adBook.html",context,resp.getWriter());
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Book book =new Book(Integer.parseInt(req.getParameter("region")),
                            req.getParameter("city"),
                            req.getParameter("province"),
                            Double.valueOf(req.getParameter("postal")));
        service.insertBook(book);
        resp.sendRedirect("book");
    }

    /**
     * @throws ServletException
     */
    ServiceImpl service;
    Context context;
    Tes user;
    @Override
    public void init() throws ServletException {
        service = new BookServiceImpl();
        context = new Context();
        user = new Tes();
    }
}
