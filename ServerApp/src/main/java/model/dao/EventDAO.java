package model.dao;

import java.util.List;
import org.hibernate.query.Query;
import model.vo.Estate;
import model.vo.Event;
import model.vo.UserApp;
import util.FacadePersistence;
import util.HibernateUtil;

@SuppressWarnings("all")
public class EventDAO extends FacadePersistence<Event> {

	public EventDAO(Class<Event> entityReference) {
		super(entityReference);
		facadePersistence = new FacadePersistence<Event>(entityReference);
	}

	private FacadePersistence<Event> facadePersistence;

	public List<Event> getEventByUser(UserApp user) {
		Query<Event> query = HibernateUtil.getSession().createNamedQuery("Event.findByUser");
		query.setParameter("phone", user.getPhone());
		return facadePersistence.getAll(query);
	}

	public List<Event> getEventByEstate(Estate estate) {
		Query<Event> query = HibernateUtil.getSession().createNamedQuery("Event.findByEstate");
		query.setParameter("idEstate", estate.getId());
		return facadePersistence.getAll(query);
	}

}
