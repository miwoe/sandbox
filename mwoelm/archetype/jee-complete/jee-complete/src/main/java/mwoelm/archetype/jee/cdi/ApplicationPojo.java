package mwoelm.archetype.jee.cdi;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import mwoelm.archetype.jee.jpa.PersistableObject;

@ApplicationScoped
public class ApplicationPojo {
	int c = 10000;
	@PersistenceContext
	EntityManager entityManager;
	
	@Resource
    private UserTransaction utx;
	
	public void doPersist() {
		try {
			utx.begin();
			for (int i = 1; i < 1000; i++) {
				c++;
				PersistableObject po = new PersistableObject();
				po.setText("done");
				po.setId(c);
				entityManager.persist(po);
			}
			utx.commit();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
