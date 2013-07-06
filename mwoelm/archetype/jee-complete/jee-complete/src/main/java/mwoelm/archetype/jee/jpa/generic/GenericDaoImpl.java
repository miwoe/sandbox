package mwoelm.archetype.jee.jpa.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK>{

	@PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

//    public long countAll(final Map<String, Object> params) {
//
//        final StringBuffer queryString = new StringBuffer(
//                "SELECT count(o) from ");
//
//        queryString.append(type.getSimpleName()).append(" o ");
//        queryString.append(this.getQueryClauses(params, null));
//
//        final Query query = this.em.createQuery(queryString.toString());
//        return (Long) query.getSingleResult();
//
//    }

    public T create(final T t) {
        this.em.persist(t);
        return t;
    }

    public void delete(final PK id) {
        this.em.remove(this.em.getReference(type, id));
    }

    public T find(final PK id) {
        return (T) this.em.find(type, id);
    }

    public T update(final T t) {
        return this.em.merge(t);    
    }

}
