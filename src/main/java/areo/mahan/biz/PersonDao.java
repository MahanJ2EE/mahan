package areo.mahan.biz;

import areo.mahan.data.Person;
import areo.mahan.data.Task;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by 931664 on 2016-02-08.
 */
@Component
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @SuppressWarnings("unchecked")
    public List<Person> list() {
        return entityManager.createQuery("select t from Person t")
                .getResultList();
    }
}
