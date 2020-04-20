package songhq.club.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME) //注解的生命周期
@Target(ElementType.METHOD) //注解可作用在的对象上  分为方法,类等。
@Inherited //该注解作用在类级别的时候是自动继承的
@Documented
public @interface MyPointCut {

}
