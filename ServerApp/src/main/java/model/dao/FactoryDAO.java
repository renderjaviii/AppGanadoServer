package model.dao;

import main.FacadePersistence;

public class FactoryDAO {	

	private CattleDAO cattle=null;
	private CattleHistoryBookDAO historyBook=null;
	private EstateDAO estate=null;
	private EventDAO event=null;
	private TankDAO tank=null;
	private UserAppDAO user=null;
	private IndicatorsDAO indicators=null;
	
	public CattleDAO getCattleDAO() {		
		return cattle==null ? new CattleDAO() : cattle;
	}
	public CattleHistoryBookDAO getCattleHistoryBookDAO() {
		return historyBook==null ? new CattleHistoryBookDAO() : historyBook;
	}
	public EstateDAO getEstateDAO() {
		return estate==null ? new EstateDAO() : estate;
	}
	public EventDAO getEventDAO() {	
		return event == null ? new EventDAO() : event;
	}
	public TankDAO getTankDAO() {
		return tank == null ? new TankDAO(): tank;
	}
	public UserAppDAO getUserDAO() {
		return user==null ? new UserAppDAO() : user;
	}

}