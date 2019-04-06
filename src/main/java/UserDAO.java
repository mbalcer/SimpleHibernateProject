import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {

    public void add(User user) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public User read(Long id) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();

        try {
            User user = session.get(User.class, id);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    public void update(Long id, User newUser) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = session.find(User.class, id);
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setAge(newUser.getAge());
            session.getTransaction().commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
