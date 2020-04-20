package songhq.club;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import songhq.club.config.MyPropertiesSource;
import songhq.club.exception.PessimisticLockingFailureException;
import songhq.club.service.MovieRecommender;
import songhq.club.service.UserService;

public class JavaBaseSpringIoc {
	

	public static void main(String[] args) throws PessimisticLockingFailureException {
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MovieRecommender.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//代码的方式指定profiles的激活的状态
		context.getEnvironment().setActiveProfiles("test", "default");
		context.scan("songhq.club");
		context.refresh();
		MovieRecommender bean = context.getBean(MovieRecommender.class);
		MyPropertiesSource bean2 = context.getBean("myPropertiesSource", MyPropertiesSource.class);
		System.out.println(bean2.getName());
		bean2.printProperties();
		bean.sayHello();
		System.out.println("-----------------");
		bean.sayGood();
		
		System.out.println("*****************");
		
		bean.invokeMyself();
		
		UserService bean3 = context.getBean("userService",UserService.class);
		
		bean3.doCurrent();
	}
}
