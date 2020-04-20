package songhq.club;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import songhq.club.factory.InstanceExample;
import songhq.club.service.UserService;

public class XMlSpringIoc {
	
	public static void main(String[] args) {
		
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("service.xml","dao.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("all.xml");
		GenericApplicationContext context = new GenericApplicationContext();
		new XmlBeanDefinitionReader(context).loadBeanDefinitions("all.xml");
		context.refresh();
		UserService userService = context.getBean("xxx", UserService.class);
		userService.sysHello();
		InstanceExample instanceExample = context.getBean("instanceExample", InstanceExample.class);
		System.out.println(instanceExample);
		//Object bean = context.getBean("&instanceExample");//&是获取FactoryBean
		//System.out.println(bean);
		//PropertyPlaceholderConfigurer
		//FactoryBean
	}
}