package util;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class FacadePersistence<T> {

	private Class<T> entityReference;
	private static Session session; // static for revision (possibles problems with multiples-sessions)

	public FacadePersistence(Class<T> entityReference) {
		this.entityReference = entityReference;
		System.out.println("Starting...");

		if (session == null)
			session = HibernateUtil.getSession();// Initialize the session
	}

	public boolean saveOrUpdate(T entity) {
		System.out.println("Creating record...");
		try {
			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("SAVE ERROR: " + e.getMessage());
			session.getTransaction().rollback();
			return false;
		}
		System.out.println("Record created");
		return true;
	}

	public T getOne(int id) {
		T genericEntity = null;
		System.out.println(entityReference);
		try {
			genericEntity = session.get(entityReference, id);// Return null in others cases
		} catch (Exception e) {
			System.err.println("GET ONE ERROR: " + e.getMessage());
		}
		System.out.println("DB's response: " + (genericEntity != null ? genericEntity.toString() : "Null"));
		return genericEntity;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		List<T> entityList = null;
		try {
			entityList = session.createQuery("SELECT t FROM " + entityReference.getSimpleName() + " t").getResultList();
		} catch (Exception e) {
			System.err.println("GET ALL ERROR: " + e.getMessage());
		}
		System.out.println("DB's response: " + (entityList != null ? entityList.toString() : "Null"));
		return entityList;
	}

	public Boolean delete(T entity) {
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

	public T getOne(Query<T> query) {// Get one using PSQL query (specific)
		T entity = null;
		try {
			entity = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("GET ONE ERROR: " + e.getMessage());
		}
		System.out.println("DB's response: " + entity);
		return entity;
	}

	public List<T> getAll(Query<T> query) {// Get all records using PSQL query (specific records)
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
