package model.dao;

import java.util.List;
import javax.persistence.Query;

import util.FacadePersistence;
import model.vo.Estate;
import model.vo.Tank;
import util.EntityManagerUtil;

@SuppressWarnings("all")
public class TankDAO extends FacadePersistence<Tank> {

    private final FacadePersistence<Tank> facadePersistence;

    public TankDAO(Class<Tank> entityReference) {
        super(entityReference);
        facadePersistence = new FacadePersistence<Tank>(entityReference);
    }

    public List<Tank> getTanksByUser(Long phoneUser) {
        Query query = EntityManagerUtil.getEntityManager().createNamedQuery("Tank.findByUser");
        query.setParameter(1, phoneUser);
        return facadePersistence.getAll(query);
    }

}
