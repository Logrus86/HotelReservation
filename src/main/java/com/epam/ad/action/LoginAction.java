package com.epam.ad.action;

import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.h2.UserDao;
import com.epam.ad.entity.User;
import com.epam.ad.pool.ConnectionPool;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Askar on 15.08.2014.
 */
public class LoginAction implements Action {
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";
    private static final String ROLES ="roles" ;
    private ActionResult welcome = new ActionResult("welcome", true);
    private ActionResult login = new ActionResult("login");
    private ActionResult adminForm = new ActionResult("adminForm",true);
    Connection connection=null;

    @Override
    public ActionResult execute(HttpServletRequest req) {
        String username = req.getParameter(USERNAME);
        String password = req.getParameter(PASSWORD);


        User user = null;
        try {
            ConnectionPool.init();
            ConnectionPool pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            UserDao userDao = new UserDao(connection);

            user = userDao.findByCredentials(username, password);


        } catch (AbstractJDBCDao.PersistException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user == null) {
            return login;

        }
        if (user.getRole().equals("ADMIN")){
            return adminForm;
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        return welcome;




    }
}
