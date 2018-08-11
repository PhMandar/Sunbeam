package com.sunbeaminfo.spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
	public static void main(String[] args) {
		
		/* With older way
		 * 480
		 * 60
		 */
		/*Box b = new Box(10, 8, 6);
		System.out.println(b.calcVolumn());
		
		Box b1 = new Box();
		b1.setHeitht(5);
		b1.setLength(4);
		b1.setWidth(3);
		System.out.println(b1.calcVolumn());*/
		
		/* With using XmlBeanFactory */
		ClassPathResource res = new ClassPathResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		Box b2 = (Box) factory.getBean("b1");
		System.out.println(b2.calcVolumn());
		
		Box b3 = (Box) factory.getBean("b2");
		System.out.println(b3.calcVolumn());
		
		
		/* With using ClassPathXmlApplicationContext */
		ClassPathXmlApplicationContext  appContext = new ClassPathXmlApplicationContext("beans.xml");
		appContext.registerShutdownHook();
		
		Box b4 = (Box) appContext.getBean("b1");
		System.out.println(b4.calcVolumn());
		
		Box b5 = (Box) appContext.getBean("b2");
		System.out.println(b5.calcVolumn());
		
		// appContext.close();
	}
}
