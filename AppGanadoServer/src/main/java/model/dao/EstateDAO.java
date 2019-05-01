package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.vo.Estate;
import util.FacadePersistence;
import util.EntityManagerUtil;
import util.EstateSize;

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

    public List<String> getEstateSize(Long phone) {
        String queryStr = "SELECT NEW util.EstateSize(e.id, e.name, COUNT(c.idEstate)) FROM Cattle AS c,"
                + " Estate AS e WHERE e.id=c.idEstate AND e.phoneUser = ?1 GROUP BY e.name, e.id";

        TypedQuery<EstateSize> query = EntityManagerUtil.getEntityManager().createQuery(queryStr, EstateSize.class);
        query.setParameter(1, phone);

        List<EstateSize> list = query.getResultList();

        List<String> stringList = new ArrayList<>();
        for (EstateSize element : list) {
            stringList.add(element.getId() + "," + element.getName() + "," + element.getCount());
        }

        return stringList;
    }

}
