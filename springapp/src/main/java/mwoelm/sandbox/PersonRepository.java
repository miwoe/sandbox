package mwoelm.sandbox;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: mwo
 * Date: 02.10.13
 * Time: 12:47
 */
@Component
public interface PersonRepository extends GraphRepository<Person> {

    Person findByName(String name);

    Iterable<Person> findByTeammatesName(String name);

}
