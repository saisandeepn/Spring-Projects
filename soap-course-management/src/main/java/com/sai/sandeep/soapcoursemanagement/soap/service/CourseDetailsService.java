package com.sai.sandeep.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sai.sandeep.soapcoursemanagement.soap.bean.Course;

@Component
public class CourseDetailsService {
	public enum Status{SUCCESS, FAILURE};
	
	private static List<Course> courses = new ArrayList<>();

	static {
		Course course1 = new Course(1, "Spring MVC", "Awesome framework");
		courses.add(course1);

		Course course2 = new Course(2, "Spring Boot", "Fantastic");
		courses.add(course2);

		Course course3 = new Course(3, "Spring Cloud", "fantabulousy");
		courses.add(course3);

		Course course4 = new Course(4, "AWS", "Next level");
		courses.add(course4);
	}

	public Course findById(int id) {
		for (Course course : courses) {
			if (course.getId() == id) {
				return course;
			}
		}
		return null;
	}

	public List<Course> findAll() {
		return courses;
	}

	public Status deleteById(int id) {
		Iterator<Course> iterator = courses.iterator();
		while (iterator.hasNext()) {
			Course course = iterator.next();
			if (course.getId() == id) {
				iterator.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}

}
