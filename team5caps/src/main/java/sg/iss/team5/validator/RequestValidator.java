package sg.iss.team5.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.team5.model.Request;

@Component
public class RequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Request.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Request r = (Request) target;
		ValidationUtils.rejectIfEmpty(errors, "studentID", "error.user.userID.empty");
		ValidationUtils.rejectIfEmpty(errors, "moduleID", "error.user.accessLevel.empty");
		System.out.println(r.toString());
	}

}
