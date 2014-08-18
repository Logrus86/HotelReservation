import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.Identified;
import com.epam.ad.dao.h2.DaoFactory;
import com.epam.ad.dao.h2.UserDao;
import com.epam.ad.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Askar on 17.08.2014.
 */
public class TestFindUserByName {
    public static void main(String[] args) throws AbstractJDBCDao.PersistException, SQLException {
        DaoFactory daoFactory=new DaoFactory();
        UserDao userDao=new UserDao(daoFactory.getContext());
        //GenericDao genericDao= daoFactory.getDao(daoFactory.getContext(), User.class);
        List<User>users=userDao.getAll();
        for (User user : users) {
            System.out.println(user.getUsername());
        }
        User user1=userDao.findByCredentials("user","123");
        System.out.println(user1.getUsername()+user1.getRole()+user1.getPassword());

        User newUser = new User();
        Identified pk = userDao.create();
        newUser.setUsername("dgdg");
        newUser.setPassword("gfhff");
        newUser.setRole("CLIENT");
        newUser.setId((Integer) pk.getId());
        userDao.update(newUser);
    }

}
