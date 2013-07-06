package mwoelm.sample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EntryPoint {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyClass myClass = ctx.getBean("myClass", MyClass.class);
		System.out.println(myClass.isField());
	}
}
