package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

    public class UserDaoHibernateImpl implements UserDao {


        public UserDaoHibernateImpl() {
        }

        //ok
    @Override
    public void createUsersTable() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String sql = "CREATE TABLE IF NOT EXISTS users"+
                    "id BIGINT not null auto_increment PRIMARY KEY, name VARVHAR(100)"+
                    " ,lastname VARCHAR(100)not null ,age TINYINT not null);";

            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            System.out.println("Таблица создана");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }


    }
//ok
    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        Session session = null;
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String sql = "DROP TABLE IF EXISTS users";
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            System.out.println("Таблица удалена");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            Util.sessionIsClose();
        }


    }

    @Override
    public void saveUser(User user) {
       Session session = null;
       Transaction transaction = null;
        try{
            session = Util.getSessionFactory().openSession();
            transaction.begin();

            user.setName(user.getName());
            user.setLastName(user.getLastName());
            user.setAge(user.getAge());

            session.save(user);

            transaction.commit();
            System.out.println("Юзер сохранён");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            Util.sessionIsClose();
        }
    }

    @Override
    public void removeUserById(Long id) {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setId(id);
        session.delete(user);

        transaction.commit();
        Util.sessionIsClose();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "SELECT * FROM users";

        session.getSession();
        Query query = session.createNativeQuery(sql);
        List<User> userList = query.list();

        transaction.commit();
        Util.sessionIsClose();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DELETE FROM users";
        session.createSQLQuery(sql);
        transaction.commit();
        Util.sessionIsClose();
        }
}
