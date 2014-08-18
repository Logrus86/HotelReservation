import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.GenericDao;
import com.epam.ad.dao.h2.BookingTableDao;
import com.epam.ad.dao.h2.DaoFactory;
import com.epam.ad.entity.BookingTable;
import org.apache.log4j.Logger;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by Askar on 30.07.2014.
 */
public class Test {

    public static final Logger LOGGER = Logger.getLogger(Test.class);
    public static void main(String[] args) throws SQLException, AbstractJDBCDao.PersistException {
        Class bookingTableClass=BookingTable.class;
        DaoFactory daoFactory=new DaoFactory();
       BookingTableDao bookingTableDao=new BookingTableDao(daoFactory.getContext());
       GenericDao genericDao= daoFactory.getDao(daoFactory.getContext(), bookingTableClass);

 //getALL
        try {
           List<BookingTable>bookingTables= genericDao.getAll();
            for (BookingTable bookingTable : bookingTables) {
                LOGGER.info(bookingTable.getId()+" "+bookingTable.getRoomNo()+" "+bookingTable.getDateFrom()+" "+bookingTable.getDayCount());
            }
//Update
            Date date= bookingTableDao.getByPK(4).getDateFrom();
            LOGGER.info(date);

            BookingTable bookingTable2=new BookingTable();

            bookingTable2.setDateFrom(date);
            bookingTable2.setDateTo(date);
            bookingTable2.setDayCount(2);
            bookingTable2.setRoomNo(9);
            bookingTable2.setId(11);

           genericDao.update(bookingTable2);

            System.out.println();

 //create
      /*  */
            //создаем пустую строку

            BookingTable newBookingtable=new BookingTable();
           newBookingtable.setDateFrom(new Date(114,7,7));
           newBookingtable.setDateTo(new Date(114,8,9));
          newBookingtable.setDayCount(5);
          newBookingtable.setRoomNo(9);
            newBookingtable.setId(bookingTableDao.create().getId());

           bookingTableDao.update(newBookingtable);

 //delete
 //genericDao.delete(bookingTableDao.getByPK(29));

            List<BookingTable>bookingTables2= bookingTableDao.getAll();
            for (BookingTable bookingTable1 : bookingTables2) {
                LOGGER.info(bookingTable1.getId()+" "+bookingTable1.getRoomNo()+" "+bookingTable1.getDateFrom()+" "+bookingTable1.getDayCount());
            }

        } catch (AbstractJDBCDao.PersistException e) {
            e.printStackTrace();
        }

    }


}
