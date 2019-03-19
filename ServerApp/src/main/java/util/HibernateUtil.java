package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;// It session factory will be uses for all sessions
	private static Session session;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			sessionFactory = new Configuration().configure().buildSessionFactory();

		return sessionFactory;
	}

	public static Session getSession() {
		if (session == null)
			session = getSessionFactory().openSession();
		
		return session;
	}
}