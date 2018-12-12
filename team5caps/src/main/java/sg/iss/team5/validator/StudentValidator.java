package sg.iss.team5.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.team5.model.Student;

@Component
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student s = (Student) target;
		ValidationUtils.rejectIfEmpty(errors, "studentID", "error.user.userID.empty");
		ValidationUtils.rejectIfEmpty(errors, "status", "error.user.emailAddress.empty");
		
		ValidationUtils.rejectIfEmpty(errors, "user.userID", "error.user.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "user.firstName", "error.user.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "user.lastName", "error.user.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "user.accessLevel", "error.user.lastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "user.emailAddress", "error.user.password.empty");
		System.out.println(s.toString());
	}

}
