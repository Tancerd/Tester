package pl.tester.mvc.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.tester.model.Course;
import pl.tester.mvc.repository.CoursesRepository;

@Repository
public class SimpleCoursesRepository implements CoursesRepository {

	private List<Course> courseList;


	public SimpleCoursesRepository() {

		courseList = new ArrayList<Course>();
		for (int i = 0; i < 10; i++) {
			Course course = new Course();
			course.setTitle("Course: " + (i+1));
			courseList.add(course);
		}
	}

	@Override
	public void addCourse(Course course) {
		courseList.add(course);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseList;
	}

}
