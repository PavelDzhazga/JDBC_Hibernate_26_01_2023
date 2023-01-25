package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(User user);


    void removeUserById(User user);

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable();
}
