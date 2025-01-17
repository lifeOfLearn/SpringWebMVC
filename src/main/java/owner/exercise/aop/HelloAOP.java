package owner.exercise.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import jakarta.annotation.PostConstruct;

@Aspect
public class HelloAOP{
	
	@PostConstruct
	public void init() {
		System.out.println("Init HelloAOP");
	}
	
	//Advice
	@Before("execution (* owner.exercise.controller.*.*(..))")
	public void doAdviceBefore() {
		System.out.println("AOP: advice: Before");
	}
	
	@After("execution (* owner.exercise.controller.*.*(..))")
	public void doAfter(){
		System.out.println("AOP: advice: After");
	}
	
//	@Around("execution (* *(..))")
//	public void doAround() {
//		System.out.println();
//	}
	
//	public interface A{}
//	public interface B extends A{}
//	public interface C extends A{}
//	public interface D extends C{}
//	
//	public class F implements B{}
//	public class G implements C{}
//	public class H implements D{}
//	public class I extends E{};
//	public class J extends F{};
//	public class K extends G{};
//	public class L extends H{};
//	public class M implements B,C{}
}



