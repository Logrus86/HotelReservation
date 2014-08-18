package com.epam.ad.action;

import com.epam.ad.dao.h2.CustomerDao;
import com.epam.ad.entity.Customer;
import com.epam.ad.pool.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class CustomerTableAction implements Action {


    public static final int STEPS_INDEX = 1;
    public static List<Customer> customers = new ArrayList<Customer>();
    private ActionResult customeradmin=new ActionResult("customerdetail");
    private ActionResult adminForm=new ActionResult("adminForm",true);
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
            String counts =request.getParameter("counts");
            if (steps.equals("1")){
                int countPlus=Integer.parseInt(counts)+10;
                request.setAttribute("counts",countPlus);

                customers.removeAll(customers);
                CustomerDao customerDao=new CustomerDao(con);
                customers=customerDao.getRange(countPlus,10);
            }else {
                int countMinus = Integer.parseInt(counts) - 10;
                request.setAttribute("counts", countMinus);

                customers.removeAll(customers);
                CustomerDao customerDao=new CustomerDao(con);
                customers=customerDao.getRange(countMinus,10);
            }
            pool.releaseConnection(con);
            ConnectionPool.dispose();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return customeradmin;
        }else {
            HttpSession session=request.getSession();
            int countsZero=-10;
            session.setAttribute("counts",countsZero);
            return adminForm;
        }


    }

}
