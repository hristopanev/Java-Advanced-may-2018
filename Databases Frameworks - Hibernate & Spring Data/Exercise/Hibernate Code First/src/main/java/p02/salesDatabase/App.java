package p02.salesDatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("sales_db");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();



        entityManager.getTransaction().commit();
    }
}
