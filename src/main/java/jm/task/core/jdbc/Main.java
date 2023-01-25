package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        Util.getSessionFactory();
        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUsersTable();

        userDao.saveUser(new User("Name1", "NameLast1", (byte) 19));
        userDao.saveUser(new User("Name2", "NameLas2", (byte) 25));
        userDao.saveUser(new User("Name3", "NameLast3", (byte) 30));
        userDao.saveUser(new User("Name4", "NameLast4", (byte) 29));

        userDao.removeUserById(new User());
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();



    }
}
