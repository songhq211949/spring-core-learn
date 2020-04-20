package songhq.club.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	public void sayInject() {
	
		System.out.println("我被注入了");
	}
	

}
