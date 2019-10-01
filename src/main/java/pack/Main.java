package pack;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		
		BusinessInter inter = (BusinessInter)context.getBean("business");
		inter.show();
		
		context.close();
	}
}
