package model.dao;

import javax.persistence.Query;
import model.vo.UserApp;
import util.FacadePersistence;
import util.EntityManagerUtil;

@SuppressWarnings("unchecked")
public class UserAppDAO extends FacadePersistence<UserApp> {

    private final FacadePersistence<UserApp> facadePersistence;

    public UserAppDAO(Class<UserApp> entityReference) {
        super(entityReference);
        facadePersistence = new FacadePersistence(entityReference);
    }

    public UserApp login(UserApp user) {
        Query query = EntityManagerUtil.getEntityManager().createNamedQuery("UserApp.login");
        query.setParameter(1, user.getPhone());
        query.setParameter(2, user.getPassword());

        return facadePersistence.getOne(query);// Return a user instance or null (if no exists)
    }

}
