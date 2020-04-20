package songhq.club.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:app.properties")
@EnableAspectJAutoProxy
public class MyPropertiesSource {
	
	@Autowired
	private Environment env;
	
	@Value("${name}")
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void printProperties() {
		System.out.println(env.getProperty("name"));
		
	}
}
