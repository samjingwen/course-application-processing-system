package sg.iss.team5.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sg.iss.team5.service.LecturerService;
import sg.iss.team5.service.StudentService;

@Controller
public class TimetableController {
	@Autowired
	private StudentService sService;
	@Autowired
	private LecturerService lService;

	@RequestMapping(value = "/Timetable")
	@Transactional
	public ModelAndView studentTimetable(HttpSession session) {
		 ModelAndView mav = new ModelAndView(" ");	
		 //String id =session.getAttribute("USERSESSION").toString();
		 String id="S00003";
				mav = new ModelAndView("Timetable");
				TreeMap<Integer, String> morcourse=new TreeMap<>();
				TreeMap<Integer, String> aftcourse=new TreeMap<>();
				TreeMap<Integer, String> evecourse=new TreeMap<>();
				 ArrayList<sg.iss.team5.model.Module> sm=new ArrayList<>();
				 String firstLetter = String.valueOf(id.charAt(0));
				 
				 //judge id is student id or lecturer id 
				 if(firstLetter.equalsIgnoreCase("S"))
				 {
					 sm=sService.findModuleByStudentId(id);
				 }
				 System.out.println(sm);
				 if(firstLetter=="L")
				 {
					 sm=lService.findModuleByLecturerId(id);
				 }
				 
				 //divide all the courses into 3 parts
				 
				 for (sg.iss.team5.model.Module module : sm) {
					if (module.getTimeslot()==1)
					{
						morcourse.put(module.getDayofWeek(), module.getCoursedetail().getCourseName()+"("+module.getVenue()+")");
					}
					if (module.getTimeslot()==2)
					{
						aftcourse.put(module.getDayofWeek(), module.getCoursedetail().getCourseName()+"("+module.getVenue()+")");
					}
					if (module.getTimeslot()==3)
					{
						evecourse.put(module.getDayofWeek(), module.getCoursedetail().getCourseName()+"("+module.getVenue()+")");
					}
				}
				 
				 //find no morning class day
				 ArrayList<Integer> listm = new ArrayList<Integer>(morcourse.keySet());
				 boolean resultm1 = listm.contains(1); 
				 boolean resultm2 = listm.contains(2); 
				 boolean resultm3 = listm.contains(3); 
				 boolean resultm4 = listm.contains(4); 
				 boolean resultm5 = listm.contains(5);
				 if(resultm1==false)
				 {morcourse.put(1, " ");}
				 if(resultm2==false)
				 {morcourse.put(2, " ");}
				 if(resultm3==false)
				 {morcourse.put(3, " ");}
				 if(resultm4==false)
				 {morcourse.put(4, " ");}
				 if(resultm5==false)
				 {morcourse.put(5, " ");}
				 
				 //find no afternoon class day
				 ArrayList<Integer> lista = new ArrayList<Integer>(aftcourse.keySet());
				 boolean resulta1 = lista.contains(1); 
				 boolean resulta2 = lista.contains(2); 
				 boolean resulta3 = lista.contains(3); 
				 boolean resulta4 = lista.contains(4); 
				 boolean resulta5 = lista.contains(5);
				 if(resulta1==false)
				 {aftcourse.put(1, " ");}
				 if(resulta2==false)
				 {aftcourse.put(2, " ");}
				 if(resulta3==false)
				 {aftcourse.put(3, " ");}
				 if(resulta4==false)
				 {aftcourse.put(4, " ");}
				 if(resulta5==false)
				 {aftcourse.put(5, " ");}
				 
				 //find no evening course day
				 ArrayList<Integer> liste = new ArrayList<Integer>(evecourse.keySet());
				 boolean resulte1 = liste.contains(1); 
				 boolean resulte2 = liste.contains(2); 
				 boolean resulte3 = liste.contains(3); 
				 boolean resulte4 = liste.contains(4); 
				 boolean resulte5 = liste.contains(5);
				 if(resulte1==false)
				 {evecourse.put(1, " ");}
				 if(resulte2==false)
				 {evecourse.put(2, " ");}
				 if(resulte3==false)
				 {evecourse.put(3, " ");}
				 if(resulte4==false)
				 {evecourse.put(4, " ");}
				 if(resulte5==false)
				 {evecourse.put(5, " ");}
				 
				 //add to m and v
				   mav.addObject("morcoursetime",morcourse);
				   mav.addObject("aftcoursetime",aftcourse);
				   mav.addObject("evecoursetime",evecourse);
				 return mav;
	}
}
