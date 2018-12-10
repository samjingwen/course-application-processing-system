package sg.iss.team5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CommonController {
	@RequestMapping("/error")
	public String showHome() {
		return "loginsuccessful";
	}
}
