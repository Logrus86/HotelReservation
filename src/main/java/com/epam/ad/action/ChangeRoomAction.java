package com.epam.ad.action;

import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.h2.BookingTableDao;
import com.epam.ad.dao.h2.RoomDao;
import com.epam.ad.entity.BookingTable;
import com.epam.ad.entity.Room;
import com.epam.ad.pool.ConnectionPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ChangeRoomAction implements Action {
private ActionResult customerform=new ActionResult("customerForm",true);
Connection connection=null;
    @Override
    public ActionResult execute(HttpServletRequest request) {
        HttpSession session=request.getSession();
        String date1 =  request.getParameter("calendar");
        String date2 = request.getParameter("calendar2");
        String roomType =  request.getParameter("roomtype");
        String bedNo =  request.getParameter("bedNo");
        session.setAttribute("dateFrom", date1);
        session.setAttribute("dateTo",date2);
        session.setAttribute("type",roomType);
        session.setAttribute("singledouble",bedNo);
        System.out.println(date1+" "+date2+" "+roomType+" "+bedNo);

        try {
            ConnectionPool.init();
            ConnectionPool pool=ConnectionPool.getInstance();
            connection=pool.takeConnection();
            List<Room> roomList = getRooms(connection);
            List<Room> selectedRooms = getUserSelectedRooms(roomType, bedNo, roomList);
            List<BookingTable> bookingTables = selectRoomsByDate(date1, date2, connection);
            RoomDao roomDao = new RoomDao(connection);
            Map<Integer, Integer> resultRooms = getFreeRoomsMap(selectedRooms, bookingTables);
            System.out.println();
            for (Map.Entry<Integer, Integer> entry : resultRooms.entrySet()) {
                System.out.println(entry.getKey().toString() + " " +resultRooms.get(entry.getKey()));
                session.setAttribute("randomRoom",roomDao.getByPK(entry.getKey()));
                session.setAttribute("prepayment",resultRooms.get(entry.getKey()));
            }
            pool.releaseConnection(connection);
            ConnectionPool.dispose();
        } catch (AbstractJDBCDao.PersistException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }

         System.out.println();
        return customerform;

    }


    private Map<Integer, Integer> getFreeRoomsMap(List<Room> selectedRooms, List<BookingTable> bookingTables) {
        Map<Integer, Integer> resultRooms = new HashMap<Integer,Integer>();
        for (Room room : selectedRooms) {
            for (BookingTable bookingTable1 : bookingTables) {

                if (room.getId().equals(bookingTable1.getRoomNo())) {
            //        System.out.println(room.getId() + "равно" + bookingTable1.getRoomNo());
                    resultRooms.put(room.getId(), room.getRoomRate());
                } else if (room.getId() < (bookingTable1.getRoomNo()) || room.getId() > (bookingTable1.getRoomNo())) {
          //          System.out.println(room.getId() + "больше или меньше" + bookingTable1.getRoomNo());
                    resultRooms.put(room.getId(), room.getRoomRate());
                } else if (room.getId() > 0 && (bookingTable1.getRoomNo().equals(null))) {
         //           System.out.println(room.getId() + "не найден" + bookingTable1.getRoomNo());
                    resultRooms.put(room.getId(), room.getRoomRate());

                }
            }
        }
        return resultRooms;
    }

    private List<BookingTable> selectRoomsByDate(String date1, String date2, Connection connection) throws AbstractJDBCDao.PersistException, SQLException {

           BookingTableDao bookingTableDao = new BookingTableDao(connection);
            List<BookingTable> bookingTables = bookingTableDao.getAll();
            for (BookingTable bookingTable : bookingTables) {
                Date dateFrom = new Date(dateConvert(date1)[0], dateConvert(date1)[1], dateConvert(date1)[2]);
                Date bookingTableDateFrom = new Date(dateConvert(bookingTable.getDateFrom().toString())[0] - 1900, dateConvert(bookingTable.getDateFrom().toString())[1], dateConvert(bookingTable.getDateFrom().toString())[2]);
                Date dateTo = new Date(dateConvert(date2)[0], dateConvert(date2)[1], dateConvert(date2)[2]);
                Date bookingTableDateTo = new Date(dateConvert(bookingTable.getDateTo().toString())[0] - 1900, dateConvert(bookingTable.getDateTo().toString())[1], dateConvert(bookingTable.getDateTo().toString())[2]);

                if (bookingTableDateFrom.getTime() < dateFrom.getTime() && bookingTableDateTo.getTime() > dateTo.getTime()) {
                    bookingTables.remove(bookingTable);
                }
                System.out.println(bookingTableDateFrom);

            }

        return bookingTables;
    }

    private List<Room> getUserSelectedRooms(String roomType, String bedNo, List<Room> roomList) {
        List<Room>changeRoom=new ArrayList<Room>();
        for (Room room : roomList) {
            if (room.getRoomBed().equals(bedNo) && room.getRoomType().equals(roomType)){
                changeRoom.add(room);
            }

        }
        return changeRoom;
    }

    private List<Room> getRooms(Connection connection) throws AbstractJDBCDao.PersistException {
       RoomDao roomDao=new RoomDao(connection);
        return roomDao.getAll();
    }

    public int[]dateConvert(String date){
        String[] split=date.split("-");
        int[]dateParam=new int[3];
        for (int i = 0; i < split.length; i++) {
            dateParam[i]=Integer.parseInt(split[i]);
        }
        return dateParam;
    }
}
