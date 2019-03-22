package model.dao;

import java.util.List;

import org.hibernate.query.Query;

import antlr.debug.Event;
import main.FacadePersistence;
import model.vo.Estate;
import model.vo.UserApp;
import util.HibernateUtil;

public class EventDAO {

	public static List<Event> getEventByUser(UserApp user){
		Query<Event> query = HibernateUtil.getSession().createNamedQuery("Event.findByUser");
		query.setParameter("phone", user.getPhone());
		return FacadePersistence.getAll(query);
	}
	
	public static List<Event> getEventByEstate(Estate estate){
		Query<Event> query = HibernateUtil.getSession().createNamedQuery("Event.findByEstate");
		query.setParameter("idEstate", estate.getId());
		return FacadePersistence.getAll(query);
	}
	
}
