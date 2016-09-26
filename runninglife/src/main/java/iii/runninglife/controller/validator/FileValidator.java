package iii.runninglife.controller.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Service
public class FileValidator implements Validator {
    
    public boolean supports(Class<?> clazz) {
        return CommonsMultipartFile.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object obj, Errors errors) {
    	CommonsMultipartFile file = (CommonsMultipartFile) obj;
            if (file.getSize() == 0) {
                errors.rejectValue("file", "missing.file");
            }
    }
}
