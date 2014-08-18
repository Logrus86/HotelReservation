package com.epam.ad.dao.h2;

import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.entity.BookingTable;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class BookingTableDao extends AbstractJDBCDao<BookingTable, Integer>{
  //  Connection connection;
    private class PersistBookingTable extends BookingTable{
        @Override
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT ID, DATE_FRO, DATE_TO, NO_OF_DAY, ROOM_NO FROM BOOKINGTABLE";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO BOOKINGTABLE(DATE_FRO, DATE_TO, NO_OF_DAY, ROOM_NO) \n" +
                "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE BOOKINGTABLE \n" +
                "SET DATE_FRO = ?, DATE_TO = ?, NO_OF_DAY = ?, ROOM_NO = ? \n" +
                "WHERE ID = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM BOOKINGTABLE WHERE ID= ?;";
    }

    @Override
    public List<BookingTable> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<BookingTable> result = new LinkedList<BookingTable>();

        try {
            while (rs.next()) {
                PersistBookingTable bookingTable = new PersistBookingTable();
                bookingTable.setId(rs.getInt("ID"));
                bookingTable.setDateFrom(rs.getDate("DATE_FRO"));
                bookingTable.setDateTo(rs.getDate("DATE_TO"));
                bookingTable.setDayCount(rs.getInt("NO_OF_DAY"));
                bookingTable.setRoomNo(rs.getInt("ROOM_NO"));

                result.add(bookingTable);

            }
        } catch (Exception e) {
            throw new PersistException(e);
        }

        return result;
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, BookingTable object) throws PersistException {
        try {
            Date sqlDateFrom=convert(object.getDateFrom());
            Date sqlDateTo=convert(object.getDateTo());

            statement.setDate(1, sqlDateFrom);
            statement.setDate(2,sqlDateTo);
            statement.setInt(3,object.getDayCount());
           statement.setInt(4,object.getRoomNo());
            statement.setInt(5,object.getId());
        }catch (Exception e){
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, BookingTable object) throws PersistException {
try {
    Date sqlDateFrom=convert(object.getDateFrom());
    Date sqlDateTo=convert(object.getDateTo());
    int roomNo;
    if (object.getRoomNo() == null) roomNo = 1;
    else roomNo = object.getRoomNo();

    statement.setDate(1, sqlDateFrom);
    statement.setDate(2,sqlDateTo);
    statement.setInt(3,object.getDayCount());
    statement.setInt(4,roomNo);

}catch (Exception e){
    throw new PersistException(e);
}
    }

    public BookingTableDao(Connection connection) {
        super(connection);

    }

    @Override
    public BookingTable create() throws SQLException, PersistException {
        BookingTable bookingTable=new BookingTable();

        return persist(bookingTable);
    }
    protected java.sql.Date convert(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }
    @Override
    public String getSelectQuery(int step) {
        //todo PreparedStatement
        return "SELECT ID, DATE_FRO, DATE_TO, NO_OF_DAY, ROOM_NO FROM BOOKINGTABLE ORDER BY ID LIMIT 10 OFFSET "+String.valueOf(step)+"";
    }



}
