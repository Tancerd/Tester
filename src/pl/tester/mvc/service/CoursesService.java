package pl.tester.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tester.model.Course;
import pl.tester.mvc.repository.CoursesRepository;

@Service
public class CoursesService {

	@Autowired private CoursesRepository coursesRepository;

	@Transactional
	public void saveOrUpdate(Course course) {
		coursesRepository.saveOrUpdate(course);
	}

	@Transactional
	public List<Course> getAllCourses() {
		return coursesRepository.getAllCourses();
	}

	@Transactional
	public List<Course> getAllAcceptedCourses() {

		List<Course> courses = coursesRepository.getAllCourses();
		List<Course> acceptedCourses = new ArrayList<Course>();

		for (Course c : courses) {
			if (c.isAccepted()) {
				acceptedCourses.add(c);
			}
		}

		return acceptedCourses;
	}

	@Transactional
	public Course getCourseByUrl(String url) {
		return coursesRepository.getCourseByUrl(url);
	}
}
