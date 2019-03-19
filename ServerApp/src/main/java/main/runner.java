package main;

import java.util.List;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import model.vo.Gender;
import util.HibernateUtil;

public class runner {
	public void crud() {

		System.out.println("Starting session");
		Session session = HibernateUtil.getSession();

		create(session);
		read(session);

		/*
		 * update(session); read(session);
		 * 
		 * delete(session); read(session);
		 */
	}

	private void create(Session session) {
		System.out.println("Creating Gender records...");
		Gender gender = new Gender();
		gender.setId(1);
		gender.setName("Hembra");

		Gender mondeo = new Gender();
		mondeo.setId(2);
		mondeo.setName("Macho");

		session.beginTransaction();
		session.save(gender);
		session.save(mondeo);
		session.getTransaction().commit();
	}

	private void read(Session session) {

		List<Gender> q = session.createNamedQuery("Gender.findAll", Gender.class).getResultList();
		System.out.println("Reading Gender records...");

		for (Gender c : q) {
			System.out.println(c.getId() + " " + c.getName());
		}
	}

	private void delete(Session session) {
		System.out.println("Deleting mondeo record...");
		Gender mondeo = (Gender) session.get(Gender.class, "mondeo");

		session.beginTransaction();
		session.delete(mondeo);
		session.getTransaction().commit();
	}

	private void update(Session session) {
		System.out.println("Updating mustang price...");
		Gender mustang = (Gender) session.get(Gender.class, "mustang");
		// mustang.setModel("mustang");
		// mustang.setPrice("£35,250.00");

		session.beginTransaction();
		session.saveOrUpdate(mustang);
		session.getTransaction().commit();
	}
}
