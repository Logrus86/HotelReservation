import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.dao.GenericDao;
import com.epam.ad.dao.Identified;
import com.epam.ad.dao.h2.CustomerDao;
import com.epam.ad.dao.h2.DaoFactory;
import com.epam.ad.entity.Customer;


import java.sql.SQLException;
import java.util.List;

/**
 * Created by Askar on 10.08.2014.
 */
public class TestCustomer {
    public static void main(String[] args) throws SQLException, AbstractJDBCDao.PersistException {
        Class customerClass=Customer.class;
        DaoFactory daoFactory=new DaoFactory();
        CustomerDao customerDao=new CustomerDao(daoFactory.getContext());
        GenericDao genericDao= daoFactory.getDao(daoFactory.getContext(), customerClass);

        //getALL
        try {
            List<Customer> customers= genericDao.getAll();
            for (Customer customer : customers) {
                System.out.println(customer.getId()+" "+customer.getFirstName()+" "+customer.getLastName()+" "+customer.getCity()+" "+customer.getCountry()+" "+customer.getRegion()+" "+customer.getPassport()+" "+customer.getEmail()+" "+customer.getPhone()+" "+customer.getPrepayment()+" "+customer.getBookId());
            }
            System.out.println();
//Update


            Customer customerUpd=new Customer();
            customerUpd.setFirstName("Ivan");
            customerUpd.setLastName("Petrov");
            customerUpd.setCity("Karaganda");
            customerUpd.setRegion("Karagandinskaya");
            customerUpd.setCountry("Kazakhstan");
            customerUpd.setPassport("2589746321");
            customerUpd.setPhone("754875");
            customerUpd.setEmail("asdasda@asdas.er");
            customerUpd.setPrepayment(1000);
            customerUpd.setBookId(5);
            customerUpd.setId(3);
            genericDao.update(customerUpd);

            System.out.println();

            //create

            //создаем пустую строку

            Customer customerCreate=new Customer();
            Identified pk=customerDao.create();
            customerCreate.setFirstName("Ivan");
            customerCreate.setLastName("Petrov");
            customerCreate.setCity("Karaganda");
            customerCreate.setRegion("Karagandinskaya");
            customerCreate.setCountry("Kazakhstan");
            customerCreate.setPassport("2589746321");
            customerCreate.setPhone("754875");
            customerCreate.setEmail("asdasda@asdas.er");
            customerCreate.setPrepayment(1000);
            customerCreate.setBookId(5);


            customerCreate.setId((Integer) pk.getId());

            genericDao.update(customerCreate);


 /* */          //delete
          //   genericDao.delete(customerDao.getByPK(6));

            List<Customer> customers2= genericDao.getAll();
            for (Customer customer : customers2) {
                System.out.println(customer.getId()+" "+customer.getFirstName()+" "+customer.getLastName()+" "+customer.getCity()+" "+customer.getCountry()+" "+customer.getRegion()+" "+customer.getPassport()+" "+customer.getEmail()+" "+customer.getPhone()+" "+customer.getPrepayment()+" "+customer.getBookId());
            }

        } catch (AbstractJDBCDao.PersistException e) {
            e.printStackTrace();
        }

    }
}
