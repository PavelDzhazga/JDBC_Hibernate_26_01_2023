package jm.task.core.jdbc.util;

import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url = "jdbc:mysql://localhost:3306/new_schema";
    private static final String userName = "Pavel Dzhazga";
    private static final String password = "25814789632GfGf";
    private static final String driver = "com.mysql.cj.jdbc.Driver";


    public static Connection getConnection(){
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            if (!connection.isClosed()) {
                System.out.println("Connection good");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Connection ERROR");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Connection ERROR");
        }
        return connection;
    }


}
