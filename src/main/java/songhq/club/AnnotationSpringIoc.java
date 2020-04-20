package songhq.club;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import songhq.club.service.MovieRecommender;

public class AnnotationSpringIoc {
	
	public static void main(String[] args) {
		
		GenericApplicationContext context = new GenericApplicationContext();
		new XmlBeanDefinitionReader(context).loadBeanDefinitions("annotation.xml");
		context.refresh();
		MovieRecommender bean = context.getBean("movieRecommender",MovieRecommender.class);
		bean.sayHello();
		System.out.println(bean);
		
	}

}
