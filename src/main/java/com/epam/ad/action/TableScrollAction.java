package com.epam.ad.action;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Askar on 17.08.2014.
 */
public class TableScrollAction implements Action {
    String next="";
    String back="";
    public TableScrollAction(String next,String back){
        this.next=next;
        this.back=back;
    }
    @Override
    public ActionResult execute(HttpServletRequest request) {

        return null;
    }
}
