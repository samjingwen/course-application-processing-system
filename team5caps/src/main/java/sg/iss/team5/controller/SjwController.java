package sg.iss.team5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SjwController {
	@RequestMapping("/sjw")
	public String showHome() {
		return "index";
	}
	
	@RequestMapping(value = {"/sjw/home"}, method = RequestMethod.GET)
	public String showTesting() {
		return "testing";
	}
}
