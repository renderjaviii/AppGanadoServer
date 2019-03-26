package model.dao;

import java.util.List;

import org.hibernate.query.Query;
import model.vo.Cattle;
import model.vo.Estate;
import model.vo.UserApp;
import util.FacadePersistence;
import util.HibernateUtil;

@SuppressWarnings("all")
public class EstateDAO extends FacadePersistence<Estate> {

	private FacadePersistence<Estate> facadePersistence;

	public EstateDAO(Class entityReference) {
		super(entityReference);
		facadePersistence = new FacadePersistence<Estate>(entityReference);
	}

	public List<Estate> getEstatesByUser(Long phone) {
		Query<Estate> query = HibernateUtil.getSession().createNamedQuery("Estate.findByUser");
		query.setParameter("phone", phone);
		return facadePersistence.getAll(query);
	}

	public Estate getEstate(Estate estate) {
		Query<Estate> query = HibernateUtil.getSession().createNamedQuery("Estate.findOne");
		query.setParameter("phone", estate.getPhoneUser());
		query.setParameter("name", estate.getName());
		return facadePersistence.getOne(query);
	}
}
