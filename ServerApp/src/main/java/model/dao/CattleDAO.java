package model.dao;

import java.util.List;

import org.hibernate.query.Query;
import main.FacadePersistence;
import model.vo.UserApp;
import util.HibernateUtil;
import model.vo.Cattle;
import model.vo.Estate;

@SuppressWarnings("unchecked")
public class CattleDAO extends FacadePersistence<Cattle> {

	public static List<Cattle> getCattlesByUser(UserApp user) {
		Query<Cattle> query = HibernateUtil.getSession().createNamedQuery("Cattle.findByUser");
		query.setParameter("phone", user.getPhone());
		return FacadePersistence.getAll(query);
	}
	
	// asas
	public static List<Cattle> getCattlesByEstate(Estate estate) {
		Query<Cattle> query = HibernateUtil.getSession().createNamedQuery("Cattle.findByEstate");
		query.setParameter("idEstate", estate.getId());
		return FacadePersistence.getAll(query);
	}
	

}
