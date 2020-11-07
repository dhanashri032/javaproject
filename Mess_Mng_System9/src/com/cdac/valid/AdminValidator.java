package com.cdac.valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.Admin;

@Service
public class AdminValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Admin.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"uname", "uname", "username required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"passWord", "passWord", "password required");
		
		Admin admin = (Admin)target;
		if(admin.getPassWord()!=null) {
			if(admin.getPassWord().length()<3) {
				errors.rejectValue("passWord", "passWord","Password should more than 3 character.");
			}
		}
	}
}
