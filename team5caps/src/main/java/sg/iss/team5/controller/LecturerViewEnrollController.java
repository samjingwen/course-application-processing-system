package sg.iss.team5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.iss.team5.service.LecturerService;
//view courses enrollment
@Controller
@RequestMapping(value="/lecturer")
public class LecturerViewEnrollController {

	@Autowired
	LecturerService lectservice;
}
