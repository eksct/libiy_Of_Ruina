package Servlet;

import javax.servlet.http.HttpSession;

public interface TesServlet {
    boolean auth(String username, String password,HttpSession session);
}
