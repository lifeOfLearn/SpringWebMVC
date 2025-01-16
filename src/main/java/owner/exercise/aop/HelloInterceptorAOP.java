package owner.exercise.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import jakarta.annotation.PostConstruct;

public class HelloInterceptorAOP implements MethodInterceptor{

	@PostConstruct
	public void init() {
		System.out.println("Init HelloInterceptorAOP");
	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("start: AOP , hello Interceptor : invocation:" + invocation);
		Object result = invocation.proceed();
		System.out.println("end: AOP, hello Interceptor");
		return result;
	}
	
	
}
