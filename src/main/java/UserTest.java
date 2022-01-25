
import com.bookstore.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserTest {
    public static void main(String[] args) {
//        User user = new User();
//        user.setFullName("javaBoy");
//        user.setEmail("ali77erffdsfdgt99@gmail.com");
//        user.setPassword("ali33");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//
//        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("A user object was created");
    }
}
