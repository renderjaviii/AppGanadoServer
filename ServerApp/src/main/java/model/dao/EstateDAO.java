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

	public List<Estate> getEstatesByUser(UserApp user) {
		Query<Estate> query = HibernateUtil.getSession().createNamedQuery("Estate.findByUser");
		query.setParameter("phone", user.getPhone());
		return facadePersistence.getAll(query);
	}
}
