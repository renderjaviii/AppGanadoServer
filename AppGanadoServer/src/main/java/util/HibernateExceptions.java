package util;

import org.hibernate.Session;

@SuppressWarnings("serial")
public class HibernateExceptions extends Exception {

	public HibernateExceptions(Session session) {
		super("ERROR: Hibernate Exception");
		session.getTransaction().rollback();
	}
}
