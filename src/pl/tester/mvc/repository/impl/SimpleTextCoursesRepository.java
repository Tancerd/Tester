package pl.tester.mvc.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.tester.mvc.repository.CoursesRepository;

@Repository
public class SimpleTextCoursesRepository implements CoursesRepository {

	private List<String> courseList;


	public SimpleTextCoursesRepository() {

		courseList = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			courseList.add("Course: " + (i+1));
		}
	}

	@Override
	public void addCourse(String course) {
		courseList.add(course);
	}

	@Override
	public List<String> getAllCourses() {
		return courseList;
	}

}
