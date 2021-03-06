package com.sai.sandeep.soapcoursemanagement.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sai.sandeep.soapcoursemanagement.soap.bean.Course;
import com.sai.sandeep.soapcoursemanagement.soap.service.CourseDetailsService;
import com.sai.sandeep.soapcoursemanagement.soap.service.CourseDetailsService.Status;
import com.saisandeep.courses.CourseDetails;
import com.saisandeep.courses.DeleteCourseDetailsRequest;
import com.saisandeep.courses.DeleteCourseDetailsResponse;
import com.saisandeep.courses.GetAllCourseDetailsRequest;
import com.saisandeep.courses.GetAllCourseDetailsResponse;
import com.saisandeep.courses.GetCourseDetailsRequest;
import com.saisandeep.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	CourseDetailsService service;

	@PayloadRoot(namespace = "http://saisandeep.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		Course course = service.findById(request.getId());
		if(course ==null)
			throw new CourseNotFoundException("Invalid Course ID "+ request.getId());
		return mapCourseDetails(course);
	}

	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(mapCourse(course));
		return response;
	}

	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for (Course course : courses) {
			CourseDetails mapCourse = mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}

	@PayloadRoot(namespace = "http://saisandeep.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(
			@RequestPayload GetAllCourseDetailsRequest request) {
		List<Course> courses = service.findAll();
		return mapAllCourseDetails(courses);
	}

	@PayloadRoot(namespace = "http://saisandeep.com/courses", localPart = "DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse deleteAllCourseDetailsRequest(
			@RequestPayload DeleteCourseDetailsRequest request) {
		Status status = service.deleteById(request.getId());
		DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
		response.setStatus(mapStatus(status));
		return response;
	}

	private com.saisandeep.courses.Status mapStatus(Status status) {
		if (status==status.FAILURE)
			return com.saisandeep.courses.Status.FAILURE;
		return com.saisandeep.courses.Status.SUCCESS;

	}

}
