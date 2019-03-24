package main;


import model.dao.CattleDAO;
import model.dao.CattleHistoryBookDAO;
import model.dao.EventDAO;
import model.dao.FactoryDAO;
import model.dao.TankDAO;
import model.dao.FactoryDAO;

import model.vo.Cattle;
import model.vo.Estate;

import model.vo.Tank;
import model.vo.UserApp;
import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class test {
	public static void main(String[] args) {

		Estate e = new Estate();
		e.setId(3);
		e.setName("Chadli");


		
		UserApp a = new UserApp();
		FactoryDAO.getUserAppDAO().saveOrUpdate(a);
		

		FactoryDAO.getEstateDAO().getAll();

		// FactoryDAO.getCattleDAO().getCattlesByEstate(e);
		FactoryDAO.getCattleDAO().getOne(1);

		FactoryDAO factoryDAO = new FactoryDAO(Cattle.class);
		factoryDAO.delete(e);
		factoryDAO.getAll();

	}
}
