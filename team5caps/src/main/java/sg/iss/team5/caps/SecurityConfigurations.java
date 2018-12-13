package sg.iss.team5.caps;

import javax.servlet.http.HttpSession;

import sg.iss.team5.controller.UserSession;

public class SecurityConfigurations {

	public static Boolean CheckAdminAuth(HttpSession session) {
		if (session.getAttribute("USERSESSION") == null)
			return false;
		if (((UserSession) session.getAttribute("USERSESSION")).getUser().getAccessLevel().equals("Administrator")) {
			return true;
		}
		return false;
	}
	public static Boolean CheckLectAuth(HttpSession session) {
		if (session.getAttribute("USERSESSION") == null)
			return false;
		if (((UserSession) session.getAttribute("USERSESSION")).getUser().getAccessLevel().equals("Lecturer")) {
			return true;
		}
		return false;
	}
	public static Boolean CheckStudAuth(HttpSession session) {
		if (session.getAttribute("USERSESSION") == null)
			return false;
		if (((UserSession) session.getAttribute("USERSESSION")).getUser().getAccessLevel().equals("Student")) {
			return true;
		}
		return false;
	}

}
