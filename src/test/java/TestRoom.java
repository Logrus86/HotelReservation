import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.GenericDao;

import com.epam.ad.dao.Identified;
import com.epam.ad.dao.h2.DaoFactory;
import com.epam.ad.dao.h2.RoomDao;
import com.epam.ad.entity.Room;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by Askar on 08.08.2014.
 */
public class TestRoom {
    public static void main(String[] args) throws SQLException, AbstractJDBCDao.PersistException {
        Class bookingTableClass=Room.class;
        DaoFactory daoFactory=new DaoFactory();
        RoomDao roomDao=new RoomDao(daoFactory.getContext());
        GenericDao genericDao= daoFactory.getDao(daoFactory.getContext(), bookingTableClass);

        //getALL
        try {
            List<Room> rooms= genericDao.getAll();
            for (Room room : rooms) {
                System.out.println(room.getId()+" "+room.getRoomNo()+" "+room.getRoomRate()+" "+room.getRoomBed()+" "+room.getRoomType());
            }
            System.out.println();
//Update

           Room roomUpd=new Room();

            roomUpd.setRoomType("Non AC");
            roomUpd.setRoomNo(118);
            roomUpd.setRoomRate(1200);
            roomUpd.setRoomBed("Double");
            roomUpd.setId(11);

            roomDao.update(roomUpd);

            System.out.println();

            //create

            //создаем пустую строку
/**/
            Room newRoom=new Room();
            Identified pk=roomDao.create();
            newRoom.setRoomType("AC!!!!!!!!");
            newRoom.setRoomBed("Single");
            newRoom.setRoomRate(10000);
            newRoom.setRoomNo(141);
            newRoom.setId((Integer) pk.getId());
           roomDao.update(newRoom);



            //delete
          //  genericDao.delete(roomDao.getByPK(92));

            List<Room> rooms1= genericDao.getAll();
            for (Room room : rooms1) {
                System.out.println(room.getId()+" "+room.getRoomNo()+" "+room.getRoomRate()+" "+room.getRoomBed()+" "+room.getRoomType());
            }

        } catch (AbstractJDBCDao.PersistException e) {
            e.printStackTrace();
        }

    }
}
