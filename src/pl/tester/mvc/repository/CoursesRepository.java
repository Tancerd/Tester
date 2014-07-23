package pl.tester.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.tester.model.Course;

@Repository
public class CoursesRepository {

	private List<Course> courseList;


	public CoursesRepository() {

		courseList = new ArrayList<Course>();
		for (int i = 0; i < 10; i++) {
			Course course = new Course();
			course.setTitle("Course: " + (i+1));
			course.setAccepted(i%2==0?true:false);
			courseList.add(course);
		}
	}

	public void saveOrUpdate(Course course) {
		courseList.add(course);
	}

	public List<Course> getAllCourses() {
		return courseList;
	}
}
