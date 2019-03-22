package model.dao;

import java.util.List;

import org.hibernate.query.Query;

import main.FacadePersistence;
import model.vo.Cattle;
import model.vo.CattleHistoryBook;
import model.vo.Estate;
import model.vo.UserApp;
import util.HibernateUtil;

public class CattleHistoryBookDAO {
	public static List<CattleHistoryBook> getCattleHistoryBookByCattle(Cattle cattle) {
		Query<CattleHistoryBook> query = HibernateUtil.getSession().createNamedQuery("CattleHistoryBook.findByEstate");
		query.setParameter("idCattle", cattle.getId());
		return FacadePersistence.getAll(query);
	}

}
