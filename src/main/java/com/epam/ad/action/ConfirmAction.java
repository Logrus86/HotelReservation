package com.epam.ad.action;

import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.Identified;
import com.epam.ad.dao.h2.BookingTableDao;
import com.epam.ad.dao.h2.CustomerDao;
import com.epam.ad.entity.BookingTable;
import com.epam.ad.entity.Customer;
import com.epam.ad.pool.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;


public class ConfirmAction implements Action {
   private BookingTable bookingTableReservation = new BookingTable();
private ActionResult reservation=new ActionResult("welcome",true);

    Connection connection=null;
    @Override
    public ActionResult execute(HttpServletRequest request) {
        String dateFrom = request.getParameter("inDateFrom");
        String dateTo = request.getParameter("inDateTo");
        String type = request.getParameter("inType");
        String roomId = request.getParameter("inRoomId");
    //    request.setAttribute("dateFrom", dateFrom);
     //   request.setAttribute("dateTo", dateTo);
     //   request.setAttribute("type", type);
     //   request.setAttribute("roomId", roomId);
        HttpSession session=request.getSession();
        session.setAttribute("yes", "Вы успешно забронировали номер!");
        String inputFirstName = request.getParameter("inputFirstName");
        String inputLastName = request.getParameter("inputLastName");
        String inputCity = request.getParameter("inputCity");
        String inputRegion = request.getParameter("inputRegion");
        String inputCountry = request.getParameter("inputCountry");
        String inputPassport = request.getParameter("inputPassport");
        String inputPhone = request.getParameter("inputPhone");
        String inputEmail = request.getParameter("inputEmail");
        String inputPrepayment = request.getParameter("inputPrepayment");
        int prepayment = (Integer.parseInt(inputPrepayment) * 50) / 100;
        System.out.println(dateFrom + " " + dateTo + " " + type + " " + roomId);
        try {
            ConnectionPool.init();
            ConnectionPool pool=ConnectionPool.getInstance();
            connection=pool.takeConnection();
            createCustomerRecord(inputFirstName, inputLastName, inputCity, inputRegion, inputCountry, inputPassport, inputPhone, inputEmail, prepayment, connection);
            createBookingTableRecord(dateFrom, dateTo, roomId, connection);
            pool.releaseConnection(connection);
            ConnectionPool.dispose();
        } catch (AbstractJDBCDao.PersistException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();

        }
        return reservation;
    }

    private void createCustomerRecord(String inputFirstName, String inputLastName, String inputCity, String inputRegion, String inputCountry, String inputPassport, String inputPhone, String inputEmail, int prepayment, Connection connection) throws AbstractJDBCDao.PersistException {

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
            customer.setBookId(getBookingTableKey(new BookingTableDao(connection)).getId());
            customerDao.update(customer);
        } catch (AbstractJDBCDao.PersistException e) {
            e.printStackTrace();


        }
    }

    private BookingTable getBookingTableKey(BookingTableDao bookingTableDao) {

        try {
            this.bookingTableReservation.setId(bookingTableDao.create().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (AbstractJDBCDao.PersistException e) {
            e.printStackTrace();
        }
        return bookingTableReservation;
    }

    private void createBookingTableRecord(String dateFrom, String dateTo, String roomId, Connection connection) throws AbstractJDBCDao.PersistException {

        try {
            BookingTableDao bookingTableDao = new BookingTableDao(connection);

            Date dateFromSql = new Date(dateConvert(dateFrom)[0] - 1900, dateConvert(dateFrom)[1] - 1, dateConvert(dateFrom)[2]);
            Date dateToSql = new Date(dateConvert(dateTo)[0] - 1900, dateConvert(dateTo)[1] - 1, dateConvert(dateTo)[2]);
            this.bookingTableReservation.setDateFrom(dateFromSql);
            this.bookingTableReservation.setDateTo(dateToSql);
            this.bookingTableReservation.setDayCount((int) (dateToSql.getTime() - dateFromSql.getTime()) / (24 * 60 * 60 * 1000));
            this.bookingTableReservation.setRoomNo(Integer.valueOf(roomId));


            bookingTableDao.update(bookingTableReservation);
        } catch (AbstractJDBCDao.PersistException e) {
            throw new RuntimeException(e);
        }

    }

    public int[] dateConvert(String date) {
        String[] split = date.split("-");
        int[] dateParam = new int[3];
        for (int i = 0; i < split.length; i++) {
            dateParam[i] = Integer.parseInt(split[i]);
        }
        return dateParam;
    }
}
