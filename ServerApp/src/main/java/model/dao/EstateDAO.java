package model.dao;

import java.util.List;

import org.hibernate.query.Query;
import main.FacadePersistence;
import model.vo.Estate;
import model.vo.UserApp;
import util.HibernateUtil;

@SuppressWarnings("unchecked")
public class EstateDAO extends FacadePersistence<Estate> {

	public static List<Estate> getEstatesByUser(UserApp user) {
		Query<Estate> query = HibernateUtil.getSession().createNamedQuery("Estate.findByUser");
		query.setParameter("phone", user.getPhone());
		return FacadePersistence.getAll(query);
	}
	
}
