package main;

import model.dao.CattleDAO;
import model.dao.CattleHistoryBookDAO;
import model.dao.EventDAO;
import model.dao.FactoryDAO;
import model.dao.TankDAO;
import model.vo.Cattle;
import model.vo.CattleHistoryBook;
import model.vo.Estate;
import model.vo.Tank;
import model.vo.UserApp;
import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class test {
	public static void main(String[] args) {

	Estate e = new Estate();
		e.setId(1);

		
		UserApp a = new UserApp();
		FactoryDAO.getUserAppDAO().saveOrUpdate(a);
		
	}
}
