package model.dao;

import util.FacadePersistence;
import util.EntityManagerUtil;
import java.util.List;
import javax.persistence.Query;
import model.vo.Cattle;
import model.vo.Estate;

@SuppressWarnings("all")
public class CattleDAO extends FacadePersistence<Cattle> {

    private static FacadePersistence<Cattle> facadePersistence;

    public CattleDAO(Class<Cattle> entityReference) {
        super(entityReference);
        facadePersistence = new FacadePersistence<Cattle>(entityReference);
    }

    public List<Cattle> getCattlesByUser(Long phone) {
        Query query = EntityManagerUtil.getEntityManager().createNamedQuery("Cattle.findByUser");
        query.setParameter(1, phone);
        return facadePersistence.getAll(query);
    }

    public List<Cattle> getCattlesByEstate(Estate estate) {
        Query query = EntityManagerUtil.getEntityManager().createNamedQuery("Cattle.findByEstate");
        query.setParameter(1, estate.getId());
        return facadePersistence.getAll(query);
    }

    public Cattle getCattle(Cattle cattle) {
        Query query = EntityManagerUtil.getEntityManager().createNamedQuery("Cattle.findOne");
        query.setParameter(1, cattle.getCode());
        query.setParameter(2, cattle.getIdEstate());
        return facadePersistence.getOne(query);
    }
}
