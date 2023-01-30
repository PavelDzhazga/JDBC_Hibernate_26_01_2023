package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class UserDaoHibernateImpl implements UserDao {


        public UserDaoHibernateImpl() {
        }


    @Override
    public void createUsersTable() {
            Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
                String sql = "CREATE TABLE IF NOT EXISTS Users " +
                        "(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                        "name VARCHAR(100) NOT NULL, " +
                        "lastName VARCHAR(100) NOT NULL, " +
                        "age SMALLINT NOT NULL)";

                session.createSQLQuery(sql).executeUpdate();

                transaction.commit();
                System.out.println("Таблица создана");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                    e.printStackTrace();
                }
                e.printStackTrace();
            }

    }


    @Override
    public void dropUsersTable() {
            Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String sql = "DROP TABLE IF EXISTS Users";
            session.createSQLQuery(sql).executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
            Transaction transaction = null;
       try (Session session = Util.getSessionFactory().openSession()) {
           transaction = session.beginTransaction();

           User user = new User(name,lastName, age);
           session.save(user);

           transaction.commit();
           System.out.println("Юзер: "+ name +", "+ lastName +", "+ age + " completed");
       } catch (Exception e) {
           if (transaction != null) {
               transaction.rollback();
           }
           e.printStackTrace();
       }

    }

    @Override
    public void removeUserById(Long id) {
            Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession();) {
            session.beginTransaction();

            User user = session.get(User.class, id);
            session.delete(user);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        Transaction transaction = null;

        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String sql = "FROM User";
            userList = session.createQuery(sql, User.class).list();

            transaction.commit();
            userList.forEach(System.out::println);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;

        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String sql = "DELETE FROM User";
            session.createQuery(sql).executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        }
}
