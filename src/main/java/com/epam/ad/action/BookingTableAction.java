package com.epam.ad.action;

import com.epam.ad.dao.h2.BookingTableDao;
import com.epam.ad.entity.BookingTable;
import com.epam.ad.pool.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class BookingTableAction implements Action {

    private ActionResult bookingtableadmin=new ActionResult("bookingtable");
    private ActionResult adminForm=new ActionResult("adminForm",true);
    public static final int STEPS_INDEX = 1;
    public static List<BookingTable> tableList = new ArrayList<BookingTable>();

    @Override
    public ActionResult execute(HttpServletRequest request) {

if (!request.getParameter("action").equals("adminRederect")) {
    ConnectionPool pool = null;
    Connection con = null;

    try {
        ConnectionPool.init();
        pool = ConnectionPool.getInstance();
        con = pool.takeConnection();

        String steps = request.getParameter("steps");
        String counts = request.getParameter("counts");
        if (steps.equals("1")) {
            int countPlus = Integer.parseInt(counts) + 10;
            request.setAttribute("counts", countPlus);
            BookingTableDao bookingTableDao = new BookingTableDao(con);
            tableList.removeAll(tableList);
            tableList = bookingTableDao.getAll(countPlus);
        } else {
            int countMinus = Integer.parseInt(counts) - 10;
            request.setAttribute("counts", countMinus);
            BookingTableDao bookingTableDao = new BookingTableDao(con);
            tableList.removeAll(tableList);
            tableList = bookingTableDao.getAll(countMinus);
        }
        pool.releaseConnection(con);
        ConnectionPool.dispose();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }


    return bookingtableadmin;
}else {
    HttpSession session=request.getSession();
    int countsZero=-10;
    session.setAttribute("counts",countsZero);
    return adminForm;
}


    }

}
