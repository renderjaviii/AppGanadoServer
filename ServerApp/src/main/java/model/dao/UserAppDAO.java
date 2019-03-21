package model.dao;

import org.hibernate.query.Query;

import main.FacadePersistence;
import model.vo.UserApp;
import util.HibernateUtil;

public class UserAppDAO extends FacadePersistence<UserApp>{

	@SuppressWarnings("unchecked")
	public static UserApp login(UserApp user) {
		Query<UserApp> query = HibernateUtil.getSession().getNamedQuery("UserApp.login");
		query.setParameter("phone", user.getPhone());
		query.setParameter("password", user.getPassword());

		return FacadePersistence.getOne(query);//Return a user instance or null (if no exists)
	}
	
}
