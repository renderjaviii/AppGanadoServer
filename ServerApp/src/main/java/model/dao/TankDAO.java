package model.dao;

import java.util.List;

import org.hibernate.query.Query;
import util.FacadePersistence;
import model.vo.Estate;
import model.vo.Tank;
import util.HibernateUtil;

@SuppressWarnings("all")
public class TankDAO extends FacadePersistence<Tank> {

	public TankDAO(Class<Tank> entityReference) {
		super(entityReference);
		facadePersistence = new FacadePersistence<Tank>(entityReference);
	}

	private FacadePersistence<Tank> facadePersistence;

	public List<Tank> getTankByEstate(Estate estate) {
		Query<Tank> query = HibernateUtil.getSession().createNamedQuery("Tank.findByEstate");
		query.setParameter("idEstate", estate.getId());
		return facadePersistence.getAll(query);
	}

}
