package com.contact.contactApp.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.contact.contactApp.model.UserDomain;
@Component
public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDomain.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDomain user = (UserDomain)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
    }
    
}
