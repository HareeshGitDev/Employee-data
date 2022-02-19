package com.employe.service.employeedata.validation;

public class MailValidation {
	public boolean doValidation(String id) {
		if (id.substring(id.length() - 10, id.length()).equals("@gmail.com") && id.length() > 11) {
		} else {
			return false;
		}
		return true;
	}

}
