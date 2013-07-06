#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
	private SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		HibernateConnection hc = new HibernateConnection();
		hc.doSomething();
	}
	
	public void doSomething() {
		sessionFactory = new Configuration()
        .configure() // configures settings from hibernate.cfg.xml
        .buildSessionFactory();
		
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}
	
}
