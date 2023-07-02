package liblyFilter;


import obj.Tes;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class Filter1 extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
            String url = req.getRequestURL().toString();
            if (!url.contains("/static/") && !url.endsWith("login")) {
                HttpSession session = req.getSession();
                Tes user = (Tes) session.getAttribute("user");
                if (user == null) {
                    res.sendRedirect("login");
                    return;
                }
            }
            chain.doFilter(req, res);
    }
}
