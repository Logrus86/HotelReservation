import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.h2.BookingTableDao;

import com.epam.ad.entity.BookingTable;
import com.epam.ad.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Askar on 12.08.2014.
 */
public class TestViewTable {
    public static void main(String[] args) throws SQLException {
        ConnectionPool pool = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ConnectionPool.init();
        pool = ConnectionPool.getInstance();
        con = pool.takeConnection();
        BookingTableDao tableDaoForView=new BookingTableDao(con);
        try {
            List<BookingTable>bookingTables=tableDaoForView.getRange(10,10);
            for (BookingTable bookingTable : bookingTables) {
                System.out.println( bookingTable.getId()+" "+bookingTable.getRoomNo());
            }
        } catch (AbstractJDBCDao.PersistException e) {
            e.printStackTrace();
        }

    }
}
