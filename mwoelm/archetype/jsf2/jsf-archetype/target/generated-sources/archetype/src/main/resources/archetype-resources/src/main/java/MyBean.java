#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

	/**
	 * @return field value
	 */
	public final String getField() {
		return field + " " + c++;
	}

	/**
	 * Sets the field value.
	 * @param field New field value
	 */
	public final void setField(final String field) {
		this.field = field;
	}
}
