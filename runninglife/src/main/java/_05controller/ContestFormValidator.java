package _05controller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import _05model.contest.ContestVO;

@Service
public class ContestFormValidator implements Validator {


//	@Autowired
//	ContestDAOimpl contestDAO;

	@Override
	public boolean supports(Class<?> clazz) {
		return ContestVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ContestVO contest = (ContestVO) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contestName", "NotEmpty.contest.contestName");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "NotEmpty.contest.startDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "place", "NotEmpty.contest.place");
//		if (contest.getStartDate(). ) {
//			errors.rejectValue("place", "NotEmpty.contestForm.place");
//		}
//
//
//		if (!user.getPassword().equals(user.getConfirmPassword())) {
//			errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
//		}
//
//		if (user.getFramework() == null || user.getFramework().size() < 2) {
//			errors.rejectValue("framework", "Valid.userForm.framework");
//		}
//
//		if (user.getSkill() == null || user.getSkill().size() < 3) {
//			errors.rejectValue("skill", "Valid.userForm.skill");
//		}errors
		List<ObjectError> list =errors.getAllErrors();
		for(ObjectError err:list){
			System.out.println(err.getCode());
		}
	}

}
