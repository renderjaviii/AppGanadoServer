package model.dao;

import java.util.List;
import javax.persistence.Query;
import model.vo.Estate;
import model.vo.Event;
import model.vo.UserApp;
import util.FacadePersistence;
import util.EntityManagerUtil;

@SuppressWarnings("all")
public class EventDAO extends FacadePersistence<Event> {

    private final FacadePersistence<Event> facadePersistence;

    public EventDAO(Class<Event> entityReference) {
        super(entityReference);
        facadePersistence = new FacadePersistence(entityReference);
    }

    public List<Event> getEventByUser(UserApp user) {
        Query query = EntityManagerUtil.getEntityManager().createNamedQuery("Tank.findByUser");
        query.setParameter(1, user.getPhone());
        return facadePersistence.getAll(query);
    }

    public List<Event> getEventByEstate(Estate estate) {
        Query query = EntityManagerUtil.getEntityManager().createNamedQuery("Event.findByEstate");
        query.setParameter(1, estate.getId());
        return facadePersistence.getAll(query);
    }

}
