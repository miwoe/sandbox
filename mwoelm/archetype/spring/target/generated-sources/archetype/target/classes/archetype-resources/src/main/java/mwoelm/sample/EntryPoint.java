#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package mwoelm.sample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EntryPoint {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyClass myClass = (MyClass) ctx.getBean("myClass");
		System.out.println(myClass.isField());
	}
}
