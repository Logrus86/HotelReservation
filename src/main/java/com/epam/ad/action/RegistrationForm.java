package com.epam.ad.action;

import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.Identified;
import com.epam.ad.dao.h2.UserDao;
import com.epam.ad.entity.User;
import com.epam.ad.pool.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;


public class RegistrationForm implements Action {
    Connection connection=null;
    ActionResult registration=new ActionResult("registrationform");
    ActionResult registration1=new ActionResult("registrationform",true);
    @Override
    public ActionResult execute(HttpServletRequest request) throws SQLException, AbstractJDBCDao.PersistException {
        String username= request.getParameter("inputUsername");
        String password=request.getParameter("inputPassword");
        String confirmpass=request.getParameter("inputConfirmPassword");


           if (!password.equals(confirmpass)){
               request.setAttribute("registrationGood","Не правильно введен пароль для подтверждения!");
               return  registration;
           }

           try{
           ConnectionPool.init();
           ConnectionPool pool=ConnectionPool.getInstance();
           connection=pool.takeConnection();
           UserDao  userDao=new UserDao(connection);
           User user=userDao.getUserByUsername(username);

           if (!(user==null)){
               request.setAttribute("registrationGood","Пользователь с таким именем уже существует!");

               return  registration;
           }



           } catch (SQLException e) {
               e.printStackTrace();
           } catch (AbstractJDBCDao.PersistException e) {
               e.printStackTrace();
           }


        createUser(username, password);
        request.setAttribute("registrationGood", "Поздравляем, вы успешно прошли регистрацию!");
        return registration;








    }

    private void createUser(String username, String password) throws SQLException, AbstractJDBCDao.PersistException {
        UserDao userDao1=new UserDao(connection);
        User newUser = new User();
        Identified pk = userDao1.create();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole("CLIENT");
        newUser.setId((Integer) pk.getId());
        userDao1.update(newUser);
    }
}
