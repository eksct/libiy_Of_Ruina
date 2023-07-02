package liblyServlet;

import Servlet.TesServlet;
import Servlet.imp.ServiceImpl;
import Servlet.imp.TesServletImp;
import Util.Util;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    ServiceImpl servletT;
    @Override
    public void init() throws ServletException {
        System.out.println("<>KOKO");
            servletT = new TesServletImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Context context = new Context();
        if (req.getSession().getAttribute("login-failure") != null){
            context.setVariable("failure",true);
            req.getSession().removeAttribute("login-failure");
        }
        if (req.getSession().getAttribute("user")!=null){
            resp.sendRedirect("index");
        }
        Util.process("login.html",context,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!(servletT.auth(req.getParameter("user"), req.getParameter("pwd"), req.getSession()))) {
            req.getSession().setAttribute("login-failure", 1);
            this.doGet(req, resp);
        } else {
            resp.sendRedirect("login");
        }
    }
}
