package mwoelm.archetype.jee.jpa.generic;

import java.io.Serializable;
import java.util.Map;


public interface GenericDao<T, PK extends Serializable> {
    /**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     *
     * @param params
     *            sql parameters
     * @return the number of records meeting the criteria
     */
//    long countAll(Map<String, Object> params);

    T create(T t);

    void delete(PK id);

    T find(PK id);

    T update(T t);   
}
