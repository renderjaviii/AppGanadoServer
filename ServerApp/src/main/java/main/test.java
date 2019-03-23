package main;


import model.dao.FactoryDAO;
import model.vo.Cattle;
import model.vo.Estate;

public class test {
	public static void main(String[] args) {

		Estate e = new Estate();
		e.setId(3);
		e.setName("Chadli");

		FactoryDAO.getEstateDAO().getAll();

		// FactoryDAO.getCattleDAO().getCattlesByEstate(e);
		FactoryDAO.getCattleDAO().getOne(1);

		FactoryDAO factoryDAO = new FactoryDAO(Cattle.class);
		factoryDAO.delete(e);
		factoryDAO.getAll();
	}
}
