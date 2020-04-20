package songhq.club.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import songhq.club.exception.PessimisticLockingFailureException;

//注意，方面实现了有序接口，这样我们就可以将方面的优先级设置为高于事务通知的优先级（我们每次重试都需要一个新的事务）
@Component
@Aspect
public class ConcurrentOperationExecutor implements Ordered{
	
	private int order = 1;
	
	private int maxRetries = 3;

	public int getOrder() {
		
		return this.order;
	}
	@Around("@annotation(songhq.club.annotation.RetriesPointCut)")
	public Object doCurrentOpreation(ProceedingJoinPoint pjp)throws Throwable {
		int numAttempts = 0;
		PessimisticLockingFailureException ex ;
		do {
			numAttempts++;
			System.out.println("重试第"+numAttempts+"次");
			try {
				return pjp.proceed();
			}
			catch (PessimisticLockingFailureException e) {
				ex = e;
				//e.printStackTrace();
			}
		} while(numAttempts <= this.maxRetries);
	
		throw ex;
	}

}
