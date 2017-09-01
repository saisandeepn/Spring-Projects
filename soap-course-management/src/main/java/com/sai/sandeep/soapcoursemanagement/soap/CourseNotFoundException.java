package com.sai.sandeep.soapcoursemanagement.soap;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode="{http://saisandeep.com/courses}001_COURSE_NOT_FOUND")
public class CourseNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CourseNotFoundException(String message) {
		super(message);
	}

}
