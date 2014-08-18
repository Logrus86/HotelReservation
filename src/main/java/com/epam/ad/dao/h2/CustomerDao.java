package com.epam.ad.dao.h2;

import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class CustomerDao extends AbstractJDBCDao<Customer,Integer>{
    @Override
    public String getSelectQuery() {
        return "SELECT ID, NAME, LAST_NAME, CITY, REGION, COUNTRY, PASSPORT, PHONE, EMAIL,  PREPAYMENT, BOOK_ID FROM CUSTDETAIL";
    }

    @Override
    public String getSelectQuery(int step) {
        return  "SELECT ID, NAME, LAST_NAME, CITY, REGION, COUNTRY, PASSPORT, PHONE, EMAIL,  PREPAYMENT, BOOK_ID FROM CUSTDETAIL ORDER BY ID LIMIT 10 OFFSET "+String.valueOf(step)+"";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO  CUSTDETAIL(NAME, LAST_NAME, CITY, REGION, COUNTRY, PASSPORT, PHONE, EMAIL,  PREPAYMENT, BOOK_ID) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE  CUSTDETAIL \n" +
                "SET NAME = ?, LAST_NAME = ?, CITY = ?, REGION = ?, COUNTRY= ?, PASSPORT= ?, PHONE= ?, EMAIL= ?,  PREPAYMENT= ?, BOOK_ID= ? \n" +
                "WHERE ID = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM CUSTDETAIL WHERE ID= ?;";
    }

    @Override
    public List<Customer> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Customer> result = new LinkedList<Customer>();
        try {
            while (rs.next()) {
                PersistCustomer customer = new PersistCustomer();
                customer.setId(rs.getInt("ID"));
                customer.setFirstName(rs.getString("NAME"));
                customer.setLastName(rs.getString("LAST_NAME"));
                customer.setCity(rs.getString("CITY"));
                customer.setRegion(rs.getString("REGION"));
                customer.setCountry(rs.getString("COUNTRY"));
                customer.setPassport(rs.getString("PASSPORT"));
                customer.setPhone(rs.getString("PHONE"));
                customer.setEmail(rs.getString("EMAIL"));
                customer.setPrepayment(rs.getInt("PREPAYMENT"));
                customer.setBookId(rs.getInt("BOOK_ID"));
                result.add(customer);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Customer object) throws PersistException {
try {
    int bookId;
    if (object.getBookId() == 0) bookId = 1;
    else bookId = object.getBookId();
    statement.setString(1,object.getFirstName());
    statement.setString(2,object.getLastName());
    statement.setString(3,object.getCity());
    statement.setString(4,object.getRegion());
    statement.setString(5,object.getCountry());
    statement.setString(6,object.getPassport());
    statement.setString(7,object.getPhone());
    statement.setString(8,object.getEmail());
    statement.setInt(9,object.getPrepayment());
    statement.setInt(10,bookId);
}catch (Exception e){
    throw new PersistException(e);
}
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Customer object) throws PersistException {
        try {
           statement.setString(1,object.getFirstName());
            statement.setString(2,object.getLastName());
            statement.setString(3,object.getCity());
            statement.setString(4,object.getRegion());
            statement.setString(5,object.getCountry());
            statement.setString(6,object.getPassport());
            statement.setString(7,object.getPhone());
            statement.setString(8,object.getEmail());
            statement.setInt(9,object.getPrepayment());
            statement.setInt(10,object.getBookId());
           statement.setInt(11,object.getId());


        }catch (Exception e){
            throw new PersistException(e);
        }

    }

    public CustomerDao(Connection connection) {
        super(connection);
    }

    @Override
    public Customer create() throws SQLException, PersistException {
        Customer customer=new Customer();

        return persist(customer);
    }

    private class PersistCustomer extends Customer {
        @Override
        public void setId(int id) {
            super.setId(id);
        }
    }
}
