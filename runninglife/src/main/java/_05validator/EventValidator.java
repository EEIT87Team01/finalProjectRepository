package _05validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import _05model.event.EventVO;

@Service
public class EventValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return EventVO.class.isAssignableFrom(clazz);
	}
	public void validate(Object obj, Errors errors) {
		EventVO event = (EventVO) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventName", "NotEmpty.eventName");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "NotEmpty.contestForm.startDate");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "place", "NotEmpty.contestForm.place");
	}
}
