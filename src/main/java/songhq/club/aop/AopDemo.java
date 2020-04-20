package songhq.club.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import songhq.club.annotation.MyPointCut;

@Component
@Aspect //spring实现了aspectj的功能，但注解模块使用的是aspectj框架中的aspectjweaver的声明部分
public class AopDemo {
	//join ponit 接入点，在spring中所有的方法可为接入点 spring默认不支持属性
	//pointcut 即按照某种条件筛选出来的接入点
	@Pointcut("execution(* sayHello(..))")
	public void  aopFunc() {
		System.out.println("执行了aop方法");
	}
	
	@Before(value = "aopFunc()")
	public void doAopFunc() {
		System.out.println("我是aop方法");
	}
	//@Around(value = "aopFunc() || @Annotation(MyPointCut)")
	@Around(value = "@annotation(songhq.club.annotation.MyPointCut)")//@annotation语法指定需全路径
	public void aroundAopFunc(ProceedingJoinPoint pjp) {
		//ProceedingJoinPoint 正在处理的连接点
		
		Object[] args = pjp.getArgs();
		for(int i=0;i<args.length;i++) {
			System.out.println(args);
		}
		Object target = pjp.getTarget();
		System.out.println(target);
		System.out.println("执行方法之前");
		try {
			pjp.proceed();
			System.out.println("执行方法之后");
		} catch (Throwable e) {
			System.out.println("执行方法异常。");
		}
		
	}
	
	
	
	
	
}
