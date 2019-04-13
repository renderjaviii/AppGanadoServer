package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory("unitGanado");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            try {
                entityManager = getEntityManagerFactory().createEntityManager();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return entityManager;
    }

    public static void close() {// Terminate
        entityManagerFactory.close();
        entityManager.close();
    }
}
