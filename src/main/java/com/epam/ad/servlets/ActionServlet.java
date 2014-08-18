package com.epam.ad.servlets;

import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.action.Action;
import com.epam.ad.action.ActionFactory;
import com.epam.ad.action.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Askar on 29.07.2014.
 */
public class ActionServlet extends HttpServlet {
    /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String actionName = request.getParameter("action");
            Action action = ActionFactory.getAction(actionName);
           ActionResult result = action.execute(request);
           request.getRequestDispatcher(result.getView()).forward(request, response);
     }*/
/*
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
*/
    private static final Logger LOGGER = LoggerFactory.getLogger(ActionServlet.class);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String actionName = request.getMethod() + request.getPathInfo();
        LOGGER.info(" Экшиннэйм приходящий в фабрику: {}", actionName);
//        System.out.println(" Экшиннэйм приходящий в фабрику...." + actionName);
        Action action = ActionFactory.getAction(actionName);
        ActionResult result = null;
        try {
            result = action.execute(request);

        if (action == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "url.not.found");
            LOGGER.info("Это путь контекстный в null.." + request.getContextPath());
            System.out.println("Это путь контекстный в null.." + request.getContextPath());
            return;
        }
        if (result.isRedirection()) {
            response.sendRedirect(request.getContextPath() + "/" + result.getView());
            LOGGER.info("Это путь контекстный в редеректе + имя странички на которую перенаправляет Экшен " + request.getContextPath() + "/" + result.getView());
            System.out.println("Это путь контекстный в редеректе + имя странички на которую перенаправляет Экшен " + request.getContextPath() + "/" + result.getView());
            return;
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/" + result.getView() + ".jsp");
        requestDispatcher.forward(request, response);
        LOGGER.info("Путь дисптетчеру, если запрос не отправляется на экшен" + "/WEB-INF/" + result.getView() + ".jsp");
        System.out.println("Путь дисптетчеру, если запрос не отправляется на экшен" + "/WEB-INF/" + result.getView() + ".jsp");

    } catch (SQLException e) {
        e.printStackTrace();
    } catch (AbstractJDBCDao.PersistException e) {
        e.printStackTrace();
    }
    }


}
