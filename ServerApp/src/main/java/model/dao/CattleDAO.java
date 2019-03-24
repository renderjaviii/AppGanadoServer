
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
	
	
	private FacadePersistence<Cattle> facadePersistence;

	public CattleDAO(Class entityReference) {
		super(entityReference);
		facadePersistence = new FacadePersistence<Cattle>(entityReference);
	}

	public List<Cattle> getCattlesByUser(UserApp user) {
		Query<Cattle> query = HibernateUtil.getSession().createNamedQuery("Cattle.findByUser");
		query.setParameter("phone", user.getPhone());
		return facadePersistence.getAll(query);
	}
	

	public  List<Cattle> getCattlesByEstate(Estate estate) {
		Query<Cattle> query = HibernateUtil.getSession().createNamedQuery("Cattle.findByEstate");
		query.setParameter("idEstate", estate.getId());
		return facadePersistence.getAll(query);
	}
	

}
