package Util;

import Servlet.imp.BookServiceImpl;
import Servlet.imp.ServiceImpl;
import Servlet.imp.StudentServiceImpl;
import obj.Tes;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * @author g
 */
public class Util {
    private static final TemplateEngine engine;
    static  {
        engine = new TemplateEngine();
        ClassLoaderTemplateResolver r = new ClassLoaderTemplateResolver();
        engine.setTemplateResolver(r);
    }

    public static void process(String template, IContext context, Writer writer) {
        engine.process(template,context,writer);
    }
    public static SqlSession mysqlConnection(boolean vis){
        try {
            SqlSession session = new SqlSessionFactoryBuilder().
                    build(Resources.
                            getResourceAsReader("mybatis-config.xml")).
                    openSession(vis);
            return session;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Integer fnow(String stud,Integer now,Integer lim){
        if ("1".equals(stud)){
            now = Math.min((now + 1), lim);

        } else if ("0".equals(stud)) {
            now = Math.max((now - 1), 0);
        }
        return now;
    }
    public static void ContextInteger(Context context,Integer[] integers, String... params){
        if (params.length!=integers.length){
            throw new IllegalArgumentException("params.length!=integers.length");
        }
        for (int i=0;i<integers.length;i++){
            context.setVariable(params[i],integers[i]);
        }
    }
    public static void  adduc(HttpServletResponse resp, HttpServletRequest req, Tes user,Context context){
        resp.setContentType("text/html;charset=UTF-8");
        user = (Tes) req.getSession().getAttribute("user");
        try {
            if (user==null){
                resp.sendRedirect("login");
                return;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        context.setVariable("user",user.getuser());
    }
    /**
     * 给两个分页用
     * */
    public static Integer prenow(HttpServletRequest req, Integer now, Integer lim, Integer level, Context context, ServiceImpl service){
        String nows = req.getParameter("nows");
        now = Util.fnow(nows,now,lim);
        Integer s = level*now;
        Integer[] ints = {lim,now};
        Util.ContextInteger(context,ints,"lim","now");
        if (service instanceof BookServiceImpl){
            context.setVariable("book",service.getBooksLimit(s,level));
        }else if (service instanceof StudentServiceImpl){
            context.setVariable("student",service.getStudentsLimit(s,level));
        }
        return now;
    }
    public static void setVariable(Context context, String[] vals, List...lists){
        for (int i=0; i<lists.length;i++){
            context.setVariable(vals[i],lists[i]);
        }
    }
}
