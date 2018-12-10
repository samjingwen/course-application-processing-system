package sg.iss.team5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	@RequestMapping("/")
	public String showHome() {
		return "index";
	}
}
