package pl.tester.mvc.repository;

import java.util.List;


public interface CoursesRepository {

	public void addCourse(String course);

	public List<String> getAllCourses();
}
