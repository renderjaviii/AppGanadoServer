package main;

import model.dao.CattleDAO;
import model.vo.UserApp;

public class test {
	public static void main(String[] args) {

		UserApp u = new UserApp();
		u.setPhone(123l);

		
		CattleDAO.getCattlesByUser(u);
		
	}
}
