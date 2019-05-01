package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import model.vo.Breed;
import util.EntityManagerUtil;
import util.FacadePersistence;
import util.EstateBreedSize;

public class BreedDAO extends FacadePersistence<Breed> {

    private static FacadePersistence<Breed> facadePersistence;

    public BreedDAO(Class<Breed> entityReference) {
        super(entityReference);
        facadePersistence = new FacadePersistence<Breed>(entityReference);
    }

    public List<String> getBreedsSize(Integer idEstate) {
        String queryStr = "SELECT NEW util.EstateBreedSize(b.name, COUNT(c.idBreed)) FROM Cattle AS c,Estate AS e,Breed AS b "
                + "WHERE c.idEstate = e.id AND b.id = c.idBreed AND e.id = ?1 GROUP BY b.name";

        TypedQuery<EstateBreedSize> query = EntityManagerUtil.getEntityManager().createQuery(queryStr, EstateBreedSize.class);
        query.setParameter(1, idEstate);
        
        List<EstateBreedSize> list = query.getResultList();

        List<String> stringList = new ArrayList<>();
        for (EstateBreedSize element : list) {
            stringList.add(element.getName() + "," + element.getCount());
        }

        return stringList;
    }

}
