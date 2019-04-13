package model.dao;

import java.util.List;
import javax.persistence.Query;
import model.vo.Estate;
import util.FacadePersistence;
import util.EntityManagerUtil;

@SuppressWarnings("all")
public class EstateDAO extends FacadePersistence<Estate> {

    private final FacadePersistence<Estate> facadePersistence;

    public EstateDAO(Class entityReference) {
        super(entityReference);
        facadePersistence = new FacadePersistence(entityReference);
    }

    public List<Estate> getEstatesByUser(Long phone) {
        Query query = EntityManagerUtil.getEntityManager().createNamedQuery("Estate.findByUser");
        query.setParameter(1, phone);
        return facadePersistence.getAll(query);
    }

    public Estate getEstateByName(Estate estate) {
        Query query = EntityManagerUtil.getEntityManager().createNamedQuery("Estate.findOne");
        query.setParameter(2, estate.getPhoneUser());
        query.setParameter(1, estate.getName());
        return facadePersistence.getOne(query);
    }

   
}
