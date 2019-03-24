package model.dao;

import java.util.List;
import org.hibernate.query.Query;
import model.vo.Cattle;
import model.vo.CattleHistoryBook;
import util.FacadePersistence;
import util.HibernateUtil;

@SuppressWarnings("all")
public class CattleHistoryBookDAO extends FacadePersistence<CattleHistoryBook> {

	public CattleHistoryBookDAO(Class<CattleHistoryBook> entityReference) {
		super(entityReference);
		facadePersistence = new FacadePersistence<CattleHistoryBook>(entityReference);
	}

	private FacadePersistence<CattleHistoryBook> facadePersistence;

	public List<CattleHistoryBook> getCattleHistoryBookByCattle(Cattle cattle) {
		Query<CattleHistoryBook> query = HibernateUtil.getSession().createNamedQuery("CattleHistoryBook.findByEstate");
		query.setParameter("idCattle", cattle.getId());
		return facadePersistence.getAll(query);
	}

}
