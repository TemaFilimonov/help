package course.dao;

import course.domain.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Артем Константинович on 02.10.2016.
 */
@Repository
@Transactional
@EnableAutoConfiguration
public class UserDao {


    public void create(User user) {
        entityManager.persist(user);
        return;
    }


    public void delete(User user) {
        if (entityManager.contains(user))
            entityManager.remove(user);
        else
            entityManager.remove(entityManager.merge(user));
        return;
    }


    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    public User findEqural(String name, String userType) {
        return (User) entityManager.createQuery(
                "from User where name = :name")
                .setParameter("name", name)
                .getSingleResult();
    }


    public User getById(long id) {
        return entityManager.find(User.class, id);
    }


    public void update(User user) {
        entityManager.merge(user);
        return;
    }

    @PersistenceContext
    private EntityManager entityManager;

}