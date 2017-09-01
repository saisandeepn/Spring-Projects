package com.sai.sandeep.soapcoursemanagement.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sai.sandeep.soapcoursemanagement.soap.bean.Course;
import com.sai.sandeep.soapcoursemanagement.soap.service.CourseDetailsService;
import com.saisandeep.courses.CourseDetails;
import com.saisandeep.courses.GetCourseDetailsRequest;
import com.saisandeep.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	CourseDetailsService service;
	
	@PayloadRoot(namespace = "http://saisandeep.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processRequest(@RequestPayload GetCourseDetailsRequest request) {
		Course course = service.findById(request.getId());
		return mapCourse(course);
	}

	private GetCourseDetailsResponse mapCourse(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		response.setCourseDetails(courseDetails);
		return response;
	}
}
