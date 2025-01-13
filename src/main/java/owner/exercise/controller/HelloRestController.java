package owner.exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("restController")
@RestController
public class HelloRestController {
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String index() {
		return "restController index";
	}
	/*
	@RequestMapping
	@PostMapping
	@RequestParam
	@RequestBody
	@ResponseBody
	@PathVariable
	@ResponseStatus
	
	@ModelAttribute
	@RequestHeader
	*/
}
