package model.dao;

import org.hibernate.query.Query;

import main.FacadePersistence;
import model.vo.CattleHistoryBook;
import model.vo.UserApp;
import util.HibernateUtil;

public class UserAppDAO extends FacadePersistence<UserApp>{
	
	
	private FacadePersistence<UserApp> facadePersistence;

	public UserAppDAO(Class<UserApp> entityReference) {
		super(entityReference);
		facadePersistence= new FacadePersistence<UserApp>(entityReference);
	}

	@SuppressWarnings("unchecked")
	public UserApp login(UserApp user) {
		Query<UserApp> query = HibernateUtil.getSession().getNamedQuery("UserApp.login");
		query.setParameter("phone", user.getPhone());
		query.setParameter("password", user.getPassword());

		return facadePersistence.getOne(query);//Return a user instance or null (if no exists)
	}
	
}
