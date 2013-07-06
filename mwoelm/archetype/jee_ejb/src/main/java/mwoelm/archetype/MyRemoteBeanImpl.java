package mwoelm.archetype;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IMyRemoteBean.class)
@Stateless
public class MyRemoteBeanImpl implements IMyRemoteBean {

	int c = 0;
	
	public int increment() {
		return c++;
	}

}
