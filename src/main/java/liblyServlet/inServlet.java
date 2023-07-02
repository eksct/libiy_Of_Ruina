package liblyServlet;

import Servlet.imp.BookServiceImpl;
import Servlet.imp.BorrowingServiceImpl;
import Servlet.imp.ServiceImpl;
import Util.Util;
import obj.Borrowing;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

import obj.Tes;
import Servlet.imp.StudentServiceImpl;

@WebServlet("/in")
public class inServlet extends HttpServlet {
    ServiceImpl Service;
    ServiceImpl serviceB;
    ServiceImpl serviceBS;
    Context context;
    Tes user;

    @Override
    public void init() throws ServletException {
        Service = new StudentServiceImpl();
        serviceB = new BookServiceImpl();
        serviceBS = new BorrowingServiceImpl();
        context = new Context();
        user = new Tes();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Util.adduc(resp,req,user,context);
        String sval[] ={"sts","bos"};
        Util.setVariable(context,sval,Service.getStudents(),serviceB.getBooksUn());
        Util.process("form.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Borrowing BS =new Borrowing();
        String sid =req.getParameter("pop");
        String bid =req.getParameter("bost");
        BS.setBosid(Integer.parseInt(sid));
        BS.setBobid(Integer.parseInt(bid));
        SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
        BS.setTime(new Date());
        serviceBS.Insert(BS);
        resp.sendRedirect("index");
    }
}
