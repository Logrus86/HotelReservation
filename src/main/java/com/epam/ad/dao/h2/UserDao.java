package com.epam.ad.dao.h2;

import com.epam.ad.dao.AbstractJDBCDao;
import com.epam.ad.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class UserDao extends AbstractJDBCDao<User,Integer> {

Connection connection=null;
    public UserDao(Connection connection) {
        super(connection);
        this.connection=connection;
    }

    public User findByCredentials(String username, String password) throws PersistException {
User user=getUserByUsername(username);


        if (!user.getUsername().equals(username) || !user.getPassword().equals(password)) return null;

        return user;
    }

public User getUserByUsername(String username) throws PersistException {
    List<User> list;
    String sql = getSelectQuery();
    sql += " WHERE LOGIN = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, username);
        ResultSet rs = statement.executeQuery();
        list = parseResultSet(rs);
    } catch (Exception e) {
        throw new PersistException(e);
    }
    if (list == null || list.size() == 0) {
        throw new PersistException("Record with PK = " + username + " not found.");
    }
    if (list.size() > 1) {
        throw new PersistException("Received more than one record.");
    }
    return list.iterator().next();


}
    @Override
    public String getSelectQuery() {
        return "SELECT ID,LOGIN,PASSWORD,ROLE FROM USER";
    }

    @Override
    public String getSelectQuery(int step) {
        return "SELECT ID,LOGIN,PASSWORD,ROLE FROM USER ORDER BY ID LIMIT 10 OFFSET "+String.valueOf(step)+"";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO USER(LOGIN,PASSWORD,ROLE) \n" +
                "VALUES (?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE USER \n" +
                "SET LOGIN = ?, PASSWORD = ?, ROLE = ? \n" +
                "WHERE ID = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM USER WHERE ID= ?;";
    }

    @Override
    public List<User> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<User> result = new LinkedList<User>();
        try {
            while (rs.next()) {
                PersistUser persistUser = new PersistUser();
                persistUser.setId(rs.getInt("ID"));
                persistUser.setUsername(rs.getString("LOGIN"));
                persistUser.setPassword(rs.getString("PASSWORD"));
                persistUser.setRole(rs.getString("ROLE"));

                result.add(persistUser);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {
        try {
            statement.setString(1,object.getUsername());
            statement.setString(2, object.getPassword());
            statement.setString(3, object.getRole());



        }catch (Exception e){
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {
        try {
            statement.setString(1,object.getUsername());
            statement.setString(2,object.getPassword());
            statement.setString(3, object.getRole());
            statement.setInt(4, object.getId());

        }catch (Exception e){
            throw new PersistException(e);
        }
    }

    @Override
    public User create() throws SQLException, PersistException {
        User user=new User();
        user.setUsername("неопред");
        user.setPassword("неопр");
        user.setRole("неопред");

        return persist(user);
    }

    private class PersistUser extends User {
        @Override
        public void setId(int id) {
            super.setId(id);
        }
    }
}
