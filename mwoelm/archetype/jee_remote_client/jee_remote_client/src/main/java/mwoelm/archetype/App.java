package mwoelm.archetype;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws NamingException, JMSException {
		Properties props = new Properties();
		props.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        props.put(Context.PROVIDER_URL, "remote://localhost:4447");
        props.put(Context.SECURITY_PRINCIPAL, "testuser");
        props.put(Context.SECURITY_CREDENTIALS, "testpassword");
        props.put("jboss.naming.client.ejb.context", true);
		InitialContext jndiContext = new InitialContext(props);
		System.out.println("\n\tGot initial Context: "+jndiContext);
//		final Context context = new InitialContext(jndiProperties);
		final String appName = "jee_ear";
		final String moduleName = "jee_ejb-0.0.1";
		final String distinctName = "";
		final String beanName = MyRemoteBeanImpl.class.getSimpleName();
		final String viewClassName = IMyRemoteBean.class.getName();
		
		Object o = jndiContext.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		System.out.println(o.toString());
		System.out.println(((IMyRemoteBean) o).increment());
		NamingEnumeration<NameClassPair> names = jndiContext.list("");
		while (names.hasMore()) {
			NameClassPair ncp = names.next();
			System.out.println(ncp.getNameInNamespace());
		}
		 ConnectionFactory cf = (ConnectionFactory) jndiContext.lookup("jms/RemoteConnectionFactory");
		 Destination destination = (Destination) jndiContext.lookup("jms/queue/test");
		 Connection connection = cf.createConnection("testuser", "testpassword");
		 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		 
		 MessageProducer messageProducer = session.createProducer(destination);
		 
		 TextMessage tm = session.createTextMessage();
		 tm.setText("Hallelulja");
		 messageProducer.send(tm);
		 session.close();
		 
	}
}
