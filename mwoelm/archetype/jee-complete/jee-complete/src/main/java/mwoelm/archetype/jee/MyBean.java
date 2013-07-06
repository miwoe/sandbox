package mwoelm.archetype.jee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mwoelm.archetype.jee.cdi.ApplicationPojo;
import mwoelm.archetype.jee.cdi.RequestPojo;
import mwoelm.archetype.jee.cdi.SessionPojo;

/**
 * This is MyBean.
 * 
 * @author mwo
 * 
 */
@ManagedBean
@SessionScoped
public class MyBean {

	/**
	 * Counter.
	 */
	private int c = 0;

	/**
	 * String.
	 */
	private String field = "Hello World";

	@Inject
	SessionPojo sessionPojo;
	
	@Inject
	ApplicationPojo applicationPojo;
	
	@Inject
	RequestPojo requestPojo;
	
	@PersistenceContext(name="org.hibernate.tutorial.jpa")
	EntityManager entityManager;
	
	/**
	 * @return field value
	 */
	public final String getField() {
		return field + " " + c++ + " " 
				+ requestPojo.toString() + " " 
				+ sessionPojo.toString() + " " 
				+ applicationPojo.toString();
	}

	public String doIt() {
		System.out.println("doIt clicked.");
		applicationPojo.doPersist();
		return "bam";
	}
	
	/**
	 * Sets the field value.
	 * @param field New field value
	 */
	public final void setField(final String field) {
		this.field = field;
	}
}
