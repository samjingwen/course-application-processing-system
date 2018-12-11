package sg.iss.team5.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.team5.model.User;
import sg.iss.team5.service.UserService;


@Controller
public class CommonController {

	@Autowired
	private UserService uService;

	@RequestMapping("/")
	public String showHome() {
		return "index";
	}

//	@RequestMapping("/testing")
//	public ModelAndView getTestData() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("testing");
//		mv.getModel().put("data", "welcome hahaha");
//		return mv;
//	}

	@RequestMapping(value = "/home/login", method = RequestMethod.GET)
	public String showLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/home/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		User u = uService.authenticate(user.getUserID(), user.getPassword());
		if (u == null)
			return mav;
		else {
			UserSession us = new UserSession();
			us.setUser(u);
			// PUT CODE FOR SETTING SESSION ID
			us.setSessionId(session.getId());
			System.out.println(u == null);
			mav = new ModelAndView("redirect:/sjw/home");
			session.setAttribute("USERSESSION", us);
			return mav;
		}
	}

}
