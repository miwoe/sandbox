package mwoelm.archetype.jee.rs;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/restfulservice")
public class RestfulWebservice {
	static HashMap<Integer, String> myMemoryConsumer = new HashMap<Integer, String>();
	static int c = 0;
	
	@GET 
	@Produces
	@Path("hello")
	public String helloWorld() {
		int d = c;
		System.out.println(c+";"+d);
		for (int i = c; i < (d+1000000);i++) {
			c++;
			myMemoryConsumer.put(c, "Dies ist ein Speicherfressender Text.");
		}
		return "Hello World " + myMemoryConsumer.size() ;
	}
}
