package com.epam.ad.dao.h2;

import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.GenericDao;
import com.epam.ad.entity.BookingTable;
import com.epam.ad.entity.Customer;
import com.epam.ad.entity.Room;
import com.epam.ad.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Askar on 06.08.2014.
 */
public class DaoFactory implements com.epam.ad.dao.DaoFactory<Connection> {
    private Map<Class, DaoCreator> creators;



    @Override
    public Connection getContext() throws AbstractJDBCDao.PersistException {
        try {
            ConnectionPool.init();
            ConnectionPool pool=ConnectionPool.getInstance();
            Connection connection = pool.takeConnection();
            return connection;
        } catch (SQLException e) {
            throw new AbstractJDBCDao.PersistException(e);
        }

    }

    @Override
    public GenericDao getDao(Connection connection, Class dtoClass) throws AbstractJDBCDao.PersistException {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new AbstractJDBCDao.PersistException("Dao object for " + dtoClass + " not found.");
        }
        return creator.create(connection);
    }

    public DaoFactory() {

        creators = new HashMap<Class, DaoCreator>();
        creators.put(Room.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new RoomDao(connection);
            }
        });
        creators.put(Customer.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new CustomerDao(connection);
            }
        });
        creators.put(BookingTable.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new BookingTableDao(connection);
            }
        });


    }
}
