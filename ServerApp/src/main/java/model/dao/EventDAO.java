package model.dao;

import java.util.List;

import org.hibernate.query.Query;

import antlr.debug.Event;
import main.FacadePersistence;
import model.vo.CattleHistoryBook;
import model.vo.Estate;
import model.vo.UserApp;
import util.HibernateUtil;

public class EventDAO extends FacadePersistence<Event>{
	


	private FacadePersistence<Event> facadePersistence;	
	public EventDAO(Class<Event> entityReference) {
		super(entityReference);
		facadePersistence=new FacadePersistence<Event>(entityReference);
	}
	


	public List<Event> getEventByUser(UserApp user){
		Query<Event> query = HibernateUtil.getSession().createNamedQuery("Event.findByUser");
		query.setParameter("phone", user.getPhone());
		return facadePersistence.getAll(query);
	}
	
	public List<Event> getEventByEstate(Estate estate){
		Query<Event> query = HibernateUtil.getSession().createNamedQuery("Event.findByEstate");
		query.setParameter("idEstate", estate.getId());
		return facadePersistence.getAll(query);
	}
	
}
