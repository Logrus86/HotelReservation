package com.epam.ad.action;

import com.epam.ad.dao.h2.RoomDao;
import com.epam.ad.entity.Room;
import com.epam.ad.pool.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;



public class RoomTableAction implements Action {


    public static final int STEPS_INDEX = 1;
    public static List<Room> rooms = new ArrayList<Room>();
    private ActionResult roomadmin=new ActionResult("roomdetail");
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
                String counts = request.getParameter("counts");
                if (steps.equals("1")) {
                    int countPlus = Integer.parseInt(counts) + 10;
                    request.setAttribute("counts", countPlus);
                    rooms.removeAll(rooms);
                    RoomDao roomDao = new RoomDao(con);
                    rooms = roomDao.getRange(countPlus,10);

                } else {
                    int countMinus = Integer.parseInt(counts) - 10;
                    request.setAttribute("counts", countMinus);
                    rooms.removeAll(rooms);
                    RoomDao roomDao = new RoomDao(con);
                    rooms = roomDao.getRange(countMinus,10);
                }


                pool.releaseConnection(con);
                ConnectionPool.dispose();


            } catch (Exception e) {
                throw new RuntimeException(e);
            }


            return roomadmin;
        }else {
            HttpSession session=request.getSession();
            int countsZero=-10;
            session.setAttribute("counts",countsZero);
            return adminForm;
        }


    }

}
