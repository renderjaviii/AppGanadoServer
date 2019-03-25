package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;// It session factory will be uses for all sessions
	private static Session session;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		return sessionFactory;
	}

	public static Session getSession() {
		if (session == null)
			try {
				session = getSessionFactory().openSession();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		return session;
	}

	public static void close() {// Terminate
		sessionFactory.close();
		session.close();
	}
}