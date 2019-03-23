package model.dao;

<<<<<<< HEAD

import main.FacadePersistence;
import model.vo.Cattle;
import model.vo.CattleHistoryBook;
import model.vo.Estate;
import model.vo.Event;
import model.vo.Tank;
import model.vo.UserApp;
import model.vo.Event;

@SuppressWarnings("all")
public class FactoryDAO extends FacadePersistence {

	private static CattleDAO cattleDAO;
	private static EstateDAO estateDAO;
	private static UserAppDAO userAppDAO;
	private static CattleHistoryBookDAO cattleHistoryBookDAO;
	private static EventDAO eventDAO;
	private static IndicatorsDAO indicatorsDAO;
	private static TankDAO tankDAO;

	public static CattleDAO getCattleDAO() {
		return cattleDAO==null ? new CattleDAO(Cattle.class) : cattleDAO;
	}
	

	public static EstateDAO getEstateDAO() {
		return estateDAO==null ? new EstateDAO(Estate.class) : estateDAO;
	}

	public static UserAppDAO getUserAppDAO() {
		return userAppDAO==null ? new UserAppDAO(UserApp.class) : userAppDAO;
	}
	
	public static CattleHistoryBookDAO getCattleHistoryBookDAO() {
		return cattleHistoryBookDAO==null ? new CattleHistoryBookDAO(CattleHistoryBook.class) : cattleHistoryBookDAO;
	}
	
	public static IndicatorsDAO getIndicatorsDAO() {
		return null;
	}
	public static TankDAO getTankDAO() {
		return tankDAO==null ? new TankDAO(Tank.class): tankDAO;
	}
	
	public static EventDAO getEventDAO(){
		
		return eventDAO==null ? /*new EventDAO(Event.class)*/ null: eventDAO;
		
		
	}

	public FactoryDAO(Class entityReference) {
		super(entityReference);
	}
	

}
=======
import model.vo.Cattle;
import model.vo.Estate;
import model.vo.UserApp;
import util.FacadePersistence;

@SuppressWarnings("all")
public class FactoryDAO extends FacadePersistence {

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

	public FactoryDAO(Class entityReference) {
		super(entityReference);
	}

}
>>>>>>> refs/remotes/origin/master
