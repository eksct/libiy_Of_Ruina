package Servlet.imp;

import Servlet.TesServlet;
import Util.Util;
import mapper.TesMapper;
import obj.Tes;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpSession;

public class TesServletImp extends ServiceImpl implements TesServlet {
    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try(SqlSession sqlSession = Util.mysqlConnection(false)) {
            Tes user = sqlSession.getMapper(TesMapper.class).selectUser(username, password);
            sqlSession.commit();
            if (user == null) {
                return false;
            }
            session.setAttribute("user", user);
            return true;
        }
    }
}
