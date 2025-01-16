package owner.exercise.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Aspect
public class HelloAOP{
	
	@PostConstruct
	public void init() {
		System.out.println("Init HelloAOP");
	}
	
	@Before("target")
	public void test1(JoinPoint joinPoint) {
		System.out.println("this A");
	}
	
	public interface A{}
	public interface B extends A{}
	public interface C extends A{}
	public interface D extends C{}
	
	public class F implements B{}
	public class G implements C{}
	public class H implements D{}
	public class I extends E{};
	public class J extends F{};
	public class K extends G{};
	public class L extends H{};
	public class M implements B,C{}
}



