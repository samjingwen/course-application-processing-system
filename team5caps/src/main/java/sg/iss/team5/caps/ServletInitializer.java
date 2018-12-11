package sg.iss.team5.caps;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import sg.iss.team5.caps.Team5capsApplication;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { Team5capsApplication.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
