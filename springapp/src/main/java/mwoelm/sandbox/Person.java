package mwoelm.sandbox;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: mwo
 * Date: 02.10.13
 * Time: 12:45
 */
@NodeEntity
public class Person {

    @GraphId
    Long id;
    public String name;

    public Person() {}
    public Person(String name) { this.name = name; }

    @RelatedTo(type="TEAMMATE", direction= Direction.BOTH)
    public @Fetch Set<Person> teammates;

    public void worksWith(Person person) {
        if (teammates == null) {
            teammates = new HashSet<Person>();
        }
        teammates.add(person);
    }

    public String toString() {
        String results = name + "'s teammates include\n";
        if (teammates != null) {
            for (Person person : teammates) {
                results += "\t- " + person.name + "\n";
            }
        }
        return results;
    }

}
