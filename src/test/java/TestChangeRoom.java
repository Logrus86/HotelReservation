import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.GenericDao;
import com.epam.ad.dao.h2.DaoFactory;
import com.epam.ad.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Askar on 09.08.2014.
 */
public class TestChangeRoom {
    public static void main(String[] args) throws AbstractJDBCDao.PersistException, SQLException {
        DaoFactory daoFactory=new DaoFactory();
        GenericDao roomDao=daoFactory.getDao(daoFactory.getContext(), Room.class);
        List<Room>roomList=roomDao.getAll();
        List<Room>changeRoom=new ArrayList<>();
        for (Room room : roomList) {
            if (room.getRoomNo()>130){
                changeRoom.add(room);
            }

        }
        for (Room room : changeRoom) {
            System.out.println(room.getRoomNo());
        }
    }


}
