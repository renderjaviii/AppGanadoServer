package model.dao;

import model.vo.Cattle;
import model.vo.Estate;
import model.vo.UserApp;

public class FactoryDAO {

	private static CattleDAO cattleDAO;
	private static EstateDAO estateDAO;
	private static UserAppDAO userAppDAO;

	public static CattleDAO getCattleDAO() {
		if (cattleDAO == null)
			cattleDAO = new CattleDAO(Cattle.class);
		return cattleDAO;
	}

	public static EstateDAO getEstateDAO() {
		if (estateDAO == null)
			estateDAO = new EstateDAO(Estate.class);
		return estateDAO;
	}

	public static UserAppDAO getUserAppDAO() {
		if (userAppDAO == null)
			userAppDAO = new UserAppDAO(UserApp.class);
		return userAppDAO;
	}
}
