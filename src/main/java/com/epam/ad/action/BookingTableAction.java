package com.epam.ad.action;

import com.epam.ad.dao.h2.BookingTableDao;
import com.epam.ad.entity.BookingTable;
import com.epam.ad.pool.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.List;


public class BookingTableAction implements Action {

    private ActionResult bookingtableadmin = new ActionResult("bookingtable");
    private ActionResult adminForm = new ActionResult("adminForm", true);
//    public static final int STEPS_INDEX = 1;
//    public static List<BookingTable> tableList = new ArrayList<BookingTable>();

    @Override
    public ActionResult execute(HttpServletRequest request) {

//        if (!request.getParameter("action").equals("adminRederect")) {
        ConnectionPool pool = null;
        Connection con = null;

        try {
            // todo move to DaoFactory
            ConnectionPool.init();
            pool = ConnectionPool.getInstance();
            con = pool.takeConnection();

//            String steps = request.getParameter("steps");
//            String counts = request.getParameter("counts");
//            if (steps.equals("1")) {
//                int countPlus = Integer.parseInt(counts) + 10;
//                request.setAttribute("counts", countPlus);
//                BookingTableDao bookingTableDao = new BookingTableDao(con);
//                tableList.removeAll(tableList);
//                tableList = bookingTableDao.getRange(countPlus, 10);
//            } else {
//                int countMinus = Integer.parseInt(counts) - 10;
//                request.setAttribute("counts", countMinus);
//                BookingTableDao bookingTableDao = new BookingTableDao(con);
//                tableList.removeAll(tableList);
//                tableList = bookingTableDao.getRange(countMinus, 10);
//            }
            int pageNumber = 1;
            int rowsCount = 10;
            String pageString = request.getParameter("page");
            String rowsString = request.getParameter("rows");
            if (pageString != null) pageNumber = Integer.valueOf(pageString);
            if (rowsString != null) rowsCount = Integer.valueOf(rowsString);

            BookingTableDao bookingTableDao = new BookingTableDao(con);
            List<BookingTable> tableList = bookingTableDao.getRange(pageNumber, rowsCount);
            request.setAttribute("list", tableList);
            request.setAttribute("pageNumber", pageNumber);
            request.setAttribute("rowsCount", rowsCount);
            ConnectionPool.dispose();
            pool.releaseConnection(con);
            return bookingtableadmin;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        } else {
//            HttpSession session = request.getSession();
//            int countsZero = -10;
//            session.setAttribute("counts", countsZero);
//            return adminForm;
//        }


    }

}
