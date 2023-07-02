package liblyServlet;

import Servlet.imp.ServiceImpl;
import Servlet.imp.StudentServiceImpl;
import Util.Util;
import obj.Tes;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stu")
public class sutdentServlet extends HttpServlet {
    ServiceImpl service;
    final Integer level = 10;
    Integer s =0,now=0,lim;
    Tes user;
    Context context;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        lim = (int)Math.ceil(service.getStudents().size()/ 10.0);
        Util.adduc(resp,req,user,context);
        now =Util.prenow(req,now,lim,level,context, service);
        s = level*now;
        Util.process("students.html",context,resp.getWriter());
    }

    /**
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
       service = new StudentServiceImpl();
       lim = (int)Math.ceil(service.getStudents().size()/ 10.0);
       user =  new Tes();
       context = new Context();
    }
}
