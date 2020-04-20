package songhq.club.dao;

import java.beans.ConstructorProperties;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	private String name;
	
	public UserDao() {
	}
	public void sayHello() {
		System.out.println("我是dao层，我的名字是"+this.name);
	}

}
