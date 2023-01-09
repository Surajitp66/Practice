package com.example.emp.domain;

import java.io.Serializable;

public class EmpResponse  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4578052429551335658L;

	
	
	private Object empRes;
	private String message;
	
	
	

	public Object getEmpRes() {
		return empRes;
	}

	public void setEmpRes(Object empRes) {
		this.empRes = empRes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
