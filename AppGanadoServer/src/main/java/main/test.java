package main;

import model.vo.Cattle;
import model.vo.Estate;
import model.vo.UserApp;

public class test {
	public static void main(String[] args) {

		
		Estate e = new Estate();
		e.setName("finca 1");
		e.setPhoneUser(1234l);

		UserApp user = new UserApp();
		user.setPhone(1234l);

		Cattle cattle = new Cattle();
		cattle.setCode(1);
		cattle.setIdEstate(1);


	}
}
