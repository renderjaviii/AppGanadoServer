package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

public abstract class FacadePersistence {

	private static Session session;

	static {// This method initialize the session
		System.out.println("Starting session");
		session = HibernateUtil.getSession();
	}

	public static <T> void saveOrUpdate(T entity) {
		System.out.println("Creating record...");
		try {
			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("SAVE ERROR: " + e.getMessage());
			session.getTransaction().rollback();
		}
	}

	public static <T> T getOne(Class<T> entityClass, int id) {
		T genericEntity = null;
		try {
			genericEntity = session.get(entityClass, id);// Return null in others cases
		} catch (Exception e) {
			System.err.println("GET ONE ERROR: " + e.getMessage());
		}
		System.out.println("DB's response: " + (genericEntity != null ? genericEntity.toString() : "Null"));
		return genericEntity;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getAll(Class<T> entityClass) {
		List<T> entityList = null;
		try {
			entityList = session.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t").getResultList();
		} catch (Exception e) {
			System.err.println("GET ALL ERROR: " + e.getMessage());
		}
		System.out.println("DB's response: " + (entityList != null ? entityList.toString() : "Null"));
		return entityList;
	}

	public static <T> Boolean delete(T entity) {
		try {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("DELETE ERROR: " + e.getMessage());
			session.getTransaction().rollback();
			return false;
		}
		return true;// If the petition is successful
	}

	public static <T> T getOne(Query<T> query) {// Get one using PSQL query (specific)
		T entity = null;
		try {
			entity = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("GET ONE ERROR: " + e.getMessage());
		}
		System.out.println("DB's response: " + entity);
		return entity;
	}

	public static <T> List<T> getAll(Query<T> query) {// Get all records using PSQL query (specific records)
		List<T> entityList = null;
		try {
			entityList = query.getResultList();
		} catch (Exception e) {
			System.out.println("GET ALL ERROR " + e.getMessage());
		}
		System.out.println("DB's response: " + entityList);
		return entityList;
	}
}
