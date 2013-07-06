package mwoelm.archetype.jee.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class XmlWebServiceImpl implements IXmlWebService {

	private int c = 0;
	
	@WebMethod
	public int increment() {
		System.out.println(c);
		return c++;
	}

}
