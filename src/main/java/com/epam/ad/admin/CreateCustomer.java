package com.epam.ad.admin;

import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.Identified;
import com.epam.ad.dao.h2.CustomerDao;
import com.epam.ad.action.ActionResult;
import com.epam.ad.entity.Customer;
import com.epam.ad.pool.ConnectionPool;
import com.epam.ad.action.Action;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;


public class CreateCustomer implements Action {
    private ActionResult createcustomeradmin = new ActionResult("customerdetail.jsp",true);
    Connection connection=null;
    @Override
    public ActionResult execute(HttpServletRequest request) {

        String inputFirstName = request.getParameter("inputFirstName");
        String inputLastName = request.getParameter("inputLastName");
        String inputCity = request.getParameter("inputCity");
        String inputRegion = request.getParameter("inputRegion");
        String inputCountry = request.getParameter("inputCountry");
        String inputPassport = request.getParameter("inputPassport");
        String inputPhone = request.getParameter("inputPhone");
        String inputEmail = request.getParameter("inputEmail");
        String inputPrepayment = request.getParameter("inputPrepayment");
        String inputBookId = request.getParameter("inputBookId");
        int bookId=Integer.parseInt(inputBookId);
        int prepayment = (Integer.parseInt(inputPrepayment) * 50) / 100;
        try {
            ConnectionPool.init();
            ConnectionPool pool=ConnectionPool.getInstance();
            connection=pool.takeConnection();
            createCustomerRecord(inputFirstName, inputLastName, inputCity, inputRegion, inputCountry, inputPassport, inputPhone, inputEmail, prepayment, bookId, connection);
            pool.releaseConnection(connection);
            ConnectionPool.dispose();
        } catch (AbstractJDBCDao.PersistException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
            return createcustomeradmin;
    }
    private void createCustomerRecord(String inputFirstName, String inputLastName, String inputCity, String inputRegion, String inputCountry, String inputPassport, String inputPhone, String inputEmail, int prepayment, int bookId, Connection connection) throws AbstractJDBCDao.PersistException {

        try {

            CustomerDao customerDao = new CustomerDao(connection);

            Customer customer = new Customer();
            customer.setFirstName(inputFirstName);
            customer.setLastName(inputLastName);
            customer.setCity(inputCity);
            customer.setRegion(inputRegion);
            customer.setCountry(inputCountry);
            customer.setPassport(inputPassport);
            customer.setPhone(inputPhone);
            customer.setEmail(inputEmail);
            customer.setPrepayment(prepayment);
            customer.setBookId(bookId);
            try {
                customer.setId(customerDao.create().getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                Identified pk = customerDao.create();
                customer.setId((Integer) pk.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            customerDao.update(customer);
        } catch (AbstractJDBCDao.PersistException e) {
            e.printStackTrace();


        }
    }
}
