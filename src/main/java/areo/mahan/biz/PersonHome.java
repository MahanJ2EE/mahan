package areo.mahan.biz;

import areo.mahan.data.Person;
import areo.mahan.data.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 931664 on 2016-02-08.
 */

@Component("personHome")
public class PersonHome {

    private static final Logger logger = LoggerFactory.getLogger(TaskHome.class);

    private Person person = new Person();
    private List<Person> persons;

    @Autowired
    private PersonDao personDao;


    public String getMessage() {
        logger.debug("Returning message from person home biz");
        return "Hello from Spring";
    }

    public Person getPerson() {
        return person;
    }

    public void savePerson() {
        personDao.save(person);
        person = new Person();
        invalidateTasks();
    }

    private void invalidateTasks() {
        persons = null;
    }

    public List<Person> getPersons() {
        if (persons == null) {
            persons = personDao.list();
        }
        return persons;

    }
}
