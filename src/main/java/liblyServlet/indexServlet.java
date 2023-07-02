package liblyServlet;

import Servlet.imp.BorrowingServiceImpl;
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

@WebServlet("/index")
public class indexServlet extends HttpServlet {
    ServiceImpl service;
    Context context ;
    Tes user;
    @Override
    public void init() throws ServletException {
        service = new BorrowingServiceImpl();
        context = new Context();
        user = new Tes();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Util.adduc(resp,req,user,context);
        context.setVariable("bor",service.getBorrowings());
        Util.process("index.html", context,resp.getWriter());
    }
}
