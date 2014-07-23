package pl.tester.mvc.repository;

import java.util.List;

import pl.tester.model.Course;


public interface CoursesRepository {

	public void addCourse(Course course);

	public List<Course> getAllCourses();
}
