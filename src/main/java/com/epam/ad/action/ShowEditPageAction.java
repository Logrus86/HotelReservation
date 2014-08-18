package com.epam.ad.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Askar on 17.08.2014.
 */
public class ShowEditPageAction implements Action {
    @Override
    public ActionResult execute(HttpServletRequest request) {
        ActionResult bookingEdit=new ActionResult("bookingtable",true);
        ActionResult roomdetailEdit=new ActionResult("roomdetail",true);
        ActionResult customerdetailEdit = new ActionResult("customerdetail",true);

        if (request.getParameter("action").equals("bookingTableEdit")){

            return bookingEdit;
        }else if (request.getParameter("action").equals("roomEdit")){
            return roomdetailEdit;
        }else {

            return customerdetailEdit;
        }

    }
}
