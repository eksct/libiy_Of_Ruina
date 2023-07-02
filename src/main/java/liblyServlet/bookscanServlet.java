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
import java.util.List;

@WebServlet("/scan")
public class bookscanServlet extends HttpServlet {
    ServiceImpl bookService;
    Context context;
    Tes user;
    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("scan");
        Util.adduc(resp,req,user,context);
        List listB= bookService.getBooksByName("%"+str+"%");
        String[] s = {"book"};
        Util.setVariable(context,s,listB);
        Util.process("bookscan.html",context,resp.getWriter());
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
    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl();
        context = new Context();
        user = new Tes();
    }
}
