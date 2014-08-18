package com.epam.ad.action;

import com.epam.ad.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Askar on 15.08.2014.
 */
public class ShowConfirmPageAction implements Action {

    private ActionResult customerform=new ActionResult("customerForm",true);


    @Override
    public ActionResult execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
//        User user = (User)session.getAttribute(USER);
//        if (user != null) return welcome;
//        return login;

        String date1 = (String) session.getAttribute("calendar");
        String date2 = (String) session.getAttribute("calendar2");
        String roomType = (String) session.getAttribute("roomtype");
        String bedNo = (String) session.getAttribute("bedNo");
        session.setAttribute("dateFrom", date1);
        session.setAttribute("dateTo", date2);
        session.setAttribute("type", roomType);
        session.setAttribute("singledouble", bedNo);
        return customerform;
    }




//        String date1 = request.getParameter("calendar");
//        String date2 = request.getParameter("calendar2");
//        String roomType = request.getParameter("roomtype");
//        String bedNo = request.getParameter("bedNo");
//        request.setAttribute("dateFrom", date1);
//        request.setAttribute("dateTo", date2);
//        request.setAttribute("type", roomType);
//        request.setAttribute("singledouble", bedNo);

}
