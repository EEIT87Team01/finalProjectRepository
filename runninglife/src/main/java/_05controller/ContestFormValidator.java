package _05controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import _05model.contest.ContestDAOimpl;
import _05model.contest.ContestVO;
import _05model.event.EventDAOimpl;

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

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contestName", "NotEmpty.contestForm.contestName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "NotEmpty.contestForm.startDate","安安");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "place", "NotEmpty.contestForm.place");
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
//		}

	}

}
