package owner.exercise.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class HelloFilterA implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Hello! Start this is HelloFilterA");
		
		chain.doFilter(request, response);
		
		System.out.println("Hello! End this is HelloFilterA");
	}
	
}
