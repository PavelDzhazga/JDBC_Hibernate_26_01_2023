package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    //UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
    private UserDao userDaoHib = new UserDaoHibernateImpl();
    public void createUsersTable() {
        userDaoHib.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHib.dropUsersTable();
    }


    public void saveUser(String name, String lastName, byte age) {
        userDaoHib.saveUser(name, lastName, age);
    }

    public void removeUserById(Long id) {
        userDaoHib.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
            return userDaoHib.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHib.cleanUsersTable();
    }
}
