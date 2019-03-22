package model.dao;

import java.util.List;

import org.hibernate.query.Query;

import main.FacadePersistence;
import model.vo.Cattle;
import model.vo.CattleHistoryBook;
import model.vo.Estate;
import model.vo.Tank;
import model.vo.UserApp;
import util.HibernateUtil;

public class CattleHistoryBookDAO extends FacadePersistence<CattleHistoryBook>{
	
	
	private FacadePersistence<CattleHistoryBook> facadePersistence;
	
	public CattleHistoryBookDAO(Class<CattleHistoryBook> entityReference) {
		super(entityReference);
		facadePersistence=new FacadePersistence<CattleHistoryBook>(entityReference);
	}

	public  List<CattleHistoryBook> getCattleHistoryBookByCattle(Cattle cattle) {
		Query<CattleHistoryBook> query = HibernateUtil.getSession().createNamedQuery("CattleHistoryBook.findByEstate");
		query.setParameter("idCattle", cattle.getId());
		return facadePersistence.getAll(query);
	}

}
