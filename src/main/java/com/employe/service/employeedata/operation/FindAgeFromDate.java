package com.employe.service.employeedata.operation;

import java.util.Date;

public class FindAgeFromDate {
	 public int getAge(Date nowDate,Date dobDate ){
		String nD,dD;
		nD=nowDate.toString();
		dD=dobDate.toString();
		return Integer.parseInt(nD.substring(nD.length()-4))-Integer.parseInt(dD.substring(dD.length()-4));
		
	}
}
