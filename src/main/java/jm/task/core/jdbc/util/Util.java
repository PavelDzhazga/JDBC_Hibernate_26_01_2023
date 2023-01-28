package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;





public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url = "jdbc:mysql://localhost:3306/dzhazgappshema";
    private static final String userName = "root";
    private static final String passw = "root";
    private static final String driver = "com.mysql.cj.jdbc.Driver";


    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, passw);
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



//Hibarnate
private  static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try{
                Configuration configuration = new Configuration();
                Properties settings = new Properties();

                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/dzhazgappshema");
                settings.put(Environment.USER, "Pavel Dzhazga");
                settings.put(Environment.PASS, "25814789632GfGf");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "");

                configuration.setProperties(settings)
                        .addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);


            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }


}
