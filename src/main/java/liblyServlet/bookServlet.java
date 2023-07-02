package liblyServlet;

import Servlet.imp.BookServiceImpl;
import Servlet.imp.ServiceImpl;
import Util.Util;
import obj.Tes;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class bookServlet extends HttpServlet {
    ServiceImpl servlet;
    final  Integer level = 10;
    int s=0,lim,now=0;
    Context context;
    Tes user ;
    @Override
    public void init() throws ServletException {
        servlet = new BookServiceImpl();
        lim =(int)Math.ceil(servlet.getBooks().size() / (level*1.0));
        context  = new Context();
        user = new Tes();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        lim =(int)Math.ceil(servlet.getBooks().size() / (level*1.0));
        Util.adduc(resp,req,user,context);
        now =Util.prenow(req,now,lim,level,context,servlet);
        s = level*now;
        Util.process("book.html",context,resp.getWriter());
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
}
