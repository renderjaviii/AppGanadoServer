package main;

import model.dao.CattleDAO;
import model.dao.CattleHistoryBookDAO;
import model.dao.EventDAO;
import model.dao.TankDAO;
import model.vo.Cattle;
import model.vo.CattleHistoryBook;
import model.vo.Estate;
import model.vo.Tank;
import model.vo.UserApp;

public class test {
	public static void main(String[] args) {

	Estate e = new Estate();
		e.setId(1);

		
		UserApp a = new UserApp();
		a.setPhone(Long.valueOf(123));
		System.out.println(TankDAO.getTankByEstate(e));
		
	}
}
