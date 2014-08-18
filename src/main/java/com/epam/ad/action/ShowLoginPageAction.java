package com.epam.ad.action;

import com.epam.ad.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Askar on 15.08.2014.
 */
public class ShowLoginPageAction implements Action {
    public static final String USER = "user";
    private ActionResult login = new ActionResult("login");
    private ActionResult welcome = new ActionResult("welcome", true);


    @Override
    public ActionResult execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        if (user != null) return welcome;
        return login;
    }
}
