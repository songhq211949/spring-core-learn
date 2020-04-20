package songhq.club.service;

import org.springframework.stereotype.Service;

import songhq.club.annotation.RetriesPointCut;
import songhq.club.dao.UserDao;
import songhq.club.exception.PessimisticLockingFailureException;

@Service
public class UserService {
	
	int count =1;
	
	private StudentService stuentService;
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public StudentService getStuentService() {
		return stuentService;
	}

	public void setStuentService(StudentService stuentService) {
		this.stuentService = stuentService;
	}

	public void sysHello() {
		System.out.println("我被实例化了");
		stuentService.sayInject();
		userDao.sayHello();
	}
	
	@RetriesPointCut
	public String doCurrent() throws PessimisticLockingFailureException{
		count++;
		
		if (count>2) {
			System.out.println("执行了2次");
			return "成功";
		}else {
			throw new PessimisticLockingFailureException();
		}
	}

}
