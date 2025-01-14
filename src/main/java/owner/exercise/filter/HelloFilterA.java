package owner.exercise.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilterA implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Hello! Start this is HelloFilterA");
		
		chain.doFilter(request, response);
		
		System.out.println("Hello! End this is HelloFilterA");
	}
	
}
