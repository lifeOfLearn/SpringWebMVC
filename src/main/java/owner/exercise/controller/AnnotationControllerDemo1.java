package owner.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//無宣告參數,bean為class名稱但第一個字為小寫
@Controller
public class AnnotationControllerDemo1 {
	//查閱test測試此項目
	
	@GetMapping("cindex")
	public String index() {
		return "index";
	}
}
