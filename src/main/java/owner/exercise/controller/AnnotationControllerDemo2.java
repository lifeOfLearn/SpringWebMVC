package owner.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//參數表示beanName
@Controller("controller2")
public class AnnotationControllerDemo2 {
	//查閱test測試此項目
	
	@GetMapping
	public String index() {
		return "index";
	}
}
