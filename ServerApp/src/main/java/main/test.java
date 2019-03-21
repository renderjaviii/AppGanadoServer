package main;

import model.dao.CattleDAO;
import model.vo.Estate;

public class test {
	public static void main(String[] args) {

		Estate e = new Estate();
		e.setId(3);
		
		CattleDAO.getCattlesByEstate(e);
	}
}
