package model.dao;

import model.vo.UserApp;
import util.FacadePersistence;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.query.Query;
import model.vo.Cattle;
import model.vo.Estate;

@SuppressWarnings("all")
public class CattleDAO extends FacadePersistence<Cattle> {

	private FacadePersistence<Cattle> facadePersistence;

	public CattleDAO(Class entityReference) {
		super(entityReference);
		facadePersistence = new FacadePersistence<Cattle>(entityReference);
	}

	public List<Cattle> getCattlesByUser(Long phone) {
		Query<Cattle> query = HibernateUtil.getSession().createNamedQuery("Cattle.findByUser");
		query.setParameter("phone", phone);

		return facadePersistence.getAll(query);
	}

	public List<Cattle> getCattlesByEstate(Estate estate) {
		Query<Cattle> query = HibernateUtil.getSession().createNamedQuery("Cattle.findByEstate");
		query.setParameter("idEstate", estate.getId());
		return facadePersistence.getAll(query);
	}

	public Cattle getCattle(Cattle cattle) {
		Query<Cattle> query = HibernateUtil.getSession().createNamedQuery("Cattle.findOne");
		query.setParameter("code", cattle.getCode());
		query.setParameter("idEstate", cattle.getIdEstate());
		return facadePersistence.getOne(query);
	}
}
