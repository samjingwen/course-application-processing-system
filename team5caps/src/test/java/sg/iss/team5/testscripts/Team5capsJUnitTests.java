package sg.iss.team5.testscripts;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import sg.iss.team5.caps.ServletInitializer;
import sg.iss.team5.caps.Team5capsApplication;
import sg.iss.team5.model.Coursedetail;
import sg.iss.team5.model.Module;
import sg.iss.team5.model.Student;
import sg.iss.team5.model.Studentcourse;
import sg.iss.team5.model.User;
import sg.iss.team5.service.AdminService;
import sg.iss.team5.service.LecturerService;
import sg.iss.team5.service.StudentService;
import sg.iss.team5.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(classes = ServletInitializer.class),
		@ContextConfiguration(classes = Team5capsApplication.class) })
@DirtiesContext
@Transactional
@Rollback(true)
public class Team5capsJUnitTests {

	@Autowired
	AdminService adservice;
	@Autowired
	LecturerService lectservice;
	@Autowired
	StudentService stuservice;
	@Autowired
	UserService uservice;

//Test of object initialization

	@Test
	public void findModuleByID_Test() {
		Module m = stuservice.findModulebyID("0118A0006");
		assertNotNull(m);
		assertEquals(3, m.getTimeslot());
	}

	@Test
	public void userAuthenticate_Test() {
		User u = uservice.authenticate("L00001", "Password");
		assertNotNull(u);
		assertEquals("Stephen", u.getFirstName());
	}

	// Due to Foreign Key Constraints, expect JpaSystemException -
	// ConstraintViolationException

	@Test(expected = JpaSystemException.class)
	public void createModule_Test() {
		Module m = new Module();
		m.setAcademicYear(Calendar.getInstance().getTime());
		m.setDayofWeek(2);
		m.setModuleID("Module 1");
		m.setTimeslot(1);
		m.setVenue("Test Venue");
		
		Module e = lectservice.updateModule(m);
		assertNotNull(m);
		
		Module insert = stuservice.findModulebyID(m.getModuleID());
		assertEquals("Test Venue",insert.getVenue());
	
	}

}
