package owner.exercise.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.PostConstruct;


@Controller
@RequestMapping("helloController")
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
