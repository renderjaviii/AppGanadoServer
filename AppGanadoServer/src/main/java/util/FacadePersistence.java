package util;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class FacadePersistence<T> {

    private static EntityManager entityManag; // static for revision (possibles problems with multiples-sessions)
    private final Class<T> entityRef;

    public FacadePersistence(Class<T> entityReference) {
        this.entityRef = entityReference;
        if (entityManag == null) {
            entityManag = EntityManagerUtil.getEntityManager();// Initialize the session
        }
    }

    public boolean save(T entity) {
        System.out.println("Creating record...");
        try {
            EntityTransaction transac = entityManag.getTransaction();
            transac.begin();

            entityManag.merge(entity);
            transac.commit();

        } catch (Exception e) {
            System.err.println("SAVE ERROR: " + e.getMessage());
            return false;
        }
        System.out.println("Created record");
        return true;
    }

    public Boolean update(T entity, Integer id) {
        System.out.println("Updating record...");
        try {
            EntityTransaction transac = entityManag.getTransaction();
            transac.begin();

            entityManag.merge(entityRef);
            transac.commit();
            System.out.println("Updated record...");

            return true;
        } catch (Exception e) {
            System.out.println("UPDATE ERROR:  " + e.getMessage());
        }
        return false;
    }

    public Boolean delete(Integer id) {
        T entity = entityManag.find(entityRef, id);
        System.out.println("Deleting record...");

        EntityTransaction transac = null;
        try {
            transac = entityManag.getTransaction();
            transac.begin();
            entityManag.remove(entity);
            transac.commit();

            System.out.println("Record deleted");
        } catch (Exception e) {
            System.err.println("DELETE ERROR: " + e.getMessage());
            transac.rollback();

            return false;
        }
        return true;// If the petition is successful
    }

    public T getOne(Integer id) {//Generic GetOne
        T entity = null;
        try {
            entity = entityManag.find(entityRef, id);// Return null if value isn't found
        } catch (Exception e) {
            System.err.println("GET ONE ERROR: " + e.getMessage());
        }
        System.out.println("Response: " + (entity != null ? entity.toString() : "null"));
        return entity;
    }

    public List<T> getAll() {//GetAll Generic
        TypedQuery allQuery = null;
        try {
            CriteriaQuery cq = entityManag.getCriteriaBuilder().createQuery(entityRef);
            Root rootEntry = cq.from(entityRef);
            CriteriaQuery all = cq.select(rootEntry);
            allQuery = entityManag.createQuery(all);
        } catch (Exception e) {
            System.err.println("GET ALL ERROR: " + e.getMessage());
        }
        List<T> responseList = allQuery.getResultList();

        System.out.println("Response: " + (responseList != null ? responseList.toString() : "null"));
        return allQuery.getResultList();
    }

    public T getOne(Query query) {// Get one using PSQL query (specific query)
        T entity = null;
        try {
            entity = (T) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("GET ONE ERROR: " + e.getMessage());
        }
        System.out.println("Response: " + entity);
        return entity;
    }

    public List<T> getAll(Query query) {// Get records using PSQL query (specific records)
        List<T> entityList = null;
        try {
            entityList = query.getResultList();

        } catch (Exception e) {
            System.out.println("GET ALL ERROR " + e.getMessage());
        }
        System.out.println("Response: " + entityList);
        return entityList;
    }

}
