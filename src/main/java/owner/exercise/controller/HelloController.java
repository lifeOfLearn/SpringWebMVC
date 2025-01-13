package owner.exercise.controller;

import java.util.Enumeration;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("controller")
@Controller
public class HelloController {
	
	@PostConstruct
	public void init() {
		System.out.println("initHello");
	}
	
	@GetMapping("hello")
	public ModelAndView hello() {
		return new ModelAndView("helloViewName");
	}
	
	@GetMapping("get")
	public ModelAndView get(HttpServletRequest request) {
		System.out.println("uri : " + request.getRequestURI());
		System.out.println("url : " + request.getRequestURL().toString());
		return new ModelAndView("get");
	}
	
}
