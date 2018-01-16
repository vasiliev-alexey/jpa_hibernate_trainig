

import domain.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTest {

    public static void main(String[] args) {

        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorlPU");


       EntityManager em = emf.createEntityManager();

       em.getTransaction().begin();


        Message msg = new Message();
        msg.setText("test data");

        em.persist(msg);

        em.getTransaction().commit();
        em.close();
        emf.close();



    }
}
