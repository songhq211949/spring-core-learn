package songhq.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import songhq.club.annotation.MyPointCut;

@Component
@Profile("test") //通过指定java -Dspring.profiles.active=dev,test这样的方式  D为指定jvm系统参数
public class MovieRecommender {

	@Autowired(required = false)
    private  CustomerPreferenceDao customerPreferenceDao;
    
    
    

//    @Autowired(required = false)
//    public MovieRecommender(@Nullable CustomerPreferenceDao customerPreferenceDao) {
//        this.customerPreferenceDao = customerPreferenceDao;
//    }
    
    
    /**
     * 下一个实例化的方法，来校验他的实例化过程
     */
    public void sayHello() {
    	System.out.println("通过注解component的方式和autowired的方式实例化了该实例");
    }
    @MyPointCut
    public void sayGood() {
    	System.out.println("我是被加强的方法");
    }
    
    public void invokeMyself() {
    	this.sayGood();
    	this.sayHello();
    }
    
    // ...
}