package model.dao;

import model.vo.Purpose;
import model.vo.Breed;
import model.vo.Cattle;
import model.vo.CattleHistoryBook;
import model.vo.Estate;
import model.vo.Event;
import model.vo.Lot;
import model.vo.Tank;
import model.vo.UserApp;

public class FactoryDAO {

	private static CattleDAO cattleDAO;
	private static EstateDAO estateDAO;
	private static UserAppDAO userAppDAO;
	private static CattleHistoryBookDAO cattleHistoryBookDAO;
	private static TankDAO tankDAO;
	private static EventDAO eventDAO;
	private static PurposeDAO purposeDAO;
	private static LotDAO lotDAO;
	private static BreedDAO breedDAO;

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

	public static CattleHistoryBookDAO getCattleHistoryBookDAO() {
		if (cattleHistoryBookDAO == null)
			cattleHistoryBookDAO = new CattleHistoryBookDAO(CattleHistoryBook.class);
		return cattleHistoryBookDAO;
	}

	public static IndicatorsDAO getIndicatorsDAO() {
		return null;
	}

	public static TankDAO getTankDAO() {
		if (tankDAO == null)
			tankDAO = new TankDAO(Tank.class);
		return tankDAO;
	}

	public static EventDAO getEventDAO() {
		if (eventDAO == null)
			eventDAO = new EventDAO(Event.class);
		return eventDAO;
	}

	public static PurposeDAO getPurposeDAO() {
		if (purposeDAO == null)
			purposeDAO = new PurposeDAO(Purpose.class);
		return purposeDAO;
	}

	public static LotDAO getLotDAO() {
		if (lotDAO == null)
			lotDAO = new LotDAO(Lot.class);
		return lotDAO;
	}

	public static BreedDAO getBreedDAO() {
		if (breedDAO == null)
			breedDAO = new BreedDAO(Breed.class);
		return breedDAO;
	}
}
