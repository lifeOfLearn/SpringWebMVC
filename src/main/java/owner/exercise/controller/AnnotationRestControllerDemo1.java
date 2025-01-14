package owner.exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//無宣告參數,bean為class名稱但第一個字為小寫
@RestController
public class AnnotationRestControllerDemo1 {

	@GetMapping("rcindex")
	public String index() {
		return "RestContrller index()";
	}
}
