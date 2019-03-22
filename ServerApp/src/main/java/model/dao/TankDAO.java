package model.dao;

import java.util.List;

import org.hibernate.query.Query;

import main.FacadePersistence;
import model.vo.Cattle;
import model.vo.Estate;
import model.vo.Tank;
import util.HibernateUtil;

public class TankDAO {

	public static List<Tank> getTankByEstate(Estate estate) {
		Query<Tank> query = HibernateUtil.getSession().createNamedQuery("Tank.findByEstate");
		query.setParameter("idEstate", estate.getId());
		return FacadePersistence.getAll(query);
	}
	
}
