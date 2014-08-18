package com.epam.ad.action;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Askar on 15.08.2014.
 */
public class ShowPageAction implements Action {
    private ActionResult actionResult;
    public ShowPageAction(String page) {
        actionResult=new ActionResult(page);
    }


    @Override
    public ActionResult execute(HttpServletRequest req) {
        return actionResult;
    }

}
