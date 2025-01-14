package owner.exercise.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("helloController")
@Controller
public class HelloController {
	
	@PostConstruct
	public void init() {
		System.out.println("init HelloController");
	}
	
	@GetMapping("hello")
	public ModelAndView hello() {
		return new ModelAndView("/pages/helloViewName");
	}
	
	@GetMapping("get")
	public ModelAndView get() {
		return new ModelAndView("/pages/get");
	}
	
}
