package model.dao;

import java.util.List;
import javax.persistence.Query;
import model.vo.Cattle;
import model.vo.CattleHistoryBook;
import util.FacadePersistence;
import util.EntityManagerUtil;

@SuppressWarnings("all")
public class CattleHistoryBookDAO extends FacadePersistence<CattleHistoryBook> {

    private final FacadePersistence<CattleHistoryBook> facadePersistence;

    public CattleHistoryBookDAO(Class<CattleHistoryBook> entityReference) {
        super(entityReference);
        facadePersistence = new FacadePersistence<CattleHistoryBook>(entityReference);
    }

    public List<CattleHistoryBook> getCattleHistoryBookByCattle(Long phoneUser) {
        Query query = EntityManagerUtil.getEntityManager().createNamedQuery("CattleHistoryBook.findByUser");
        query.setParameter(1, phoneUser);
        return facadePersistence.getAll(query);
    }

}
