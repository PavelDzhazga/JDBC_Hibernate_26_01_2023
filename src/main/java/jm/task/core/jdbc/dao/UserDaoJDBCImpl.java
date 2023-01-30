package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

/*
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;


public class UserDaoJDBCImpl implements UserDao {

    Statement = null;

    public void createUsersTable() {
        try (Connection con = getConnection(); Statement statement = getConnection().createStatement()){
            String create = "CREATE TABLE IF NOT EXISTS `new_schema`.`user` (\n" +
                    "  `idUser` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` VARCHAR(45) NULL,\n" +
                    "  `Last_name` VARCHAR(45) NULL,\n" +
                    "  `age` INT NULL,\n" +
                    "  PRIMARY KEY (`idUser`),\n" +
                    "  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC) VISIBLE)";
            statement.executeUpdate(create);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try (Connection conn = getConnection(); Statement statement = getConnection().createStatement()){
            String drop = "DROP TABLE IF EXISTS user";
            statement.executeUpdate(drop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
       try (Connection connection = getConnection()){
           String save = "INSERT INTO user(Name, Last_name, age) \n" +
                   " VALUES(?, ?, ?)";
           PreparedStatement preSta = connection.prepareStatement(save);
           preSta.setString(1, name);
           preSta.setString(2, lastName);
           preSta.setByte(3, age);
           preSta.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }

    public void removeUserById(long id) {
        String delete = "DELETE FROM user WHERE idUser =?";
        try (Connection connection = getConnection(); PreparedStatement preSta = connection.prepareStatement(delete)){
            preSta.setLong(1,id);
            preSta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        String getAll = "SELECT * FROM user";
        User user = new User();
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection(); Statement statement = getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery(getAll);

            while (resultSet.next()) {
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                userList.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        try (Connection connection = getConnection(); Statement statement = getConnection().createStatement()){
            String clean = "DELETE FROM user";
            statement.executeUpdate(clean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   */

