package pl.tester.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.tester.model.Course;
import pl.tester.model.Exam;

@Repository
public class CoursesRepository {

	private List<Course> courseList;


	public CoursesRepository() {

		courseList = new ArrayList<Course>();
		for (int i = 0; i < 10; i++) {
			Course course = new Course();
			course.setTitle("Course " + (i+1));
			course.setUrl(course.getTitle().replace(" ", "_").toLowerCase());
			course.setAccepted(i%2==0?true:false);
			List<Exam> exams = new ArrayList<>();
			for (int j = 0; j < 2; j++) {
				Exam exam = new Exam();
				exam.setTitle("Exam " + (j+1));
				exams.add(exam);
			}
			course.setExamList(exams);
			courseList.add(course);
		}
	}

	public void saveOrUpdate(Course course) {
		courseList.add(course);
	}

	public List<Course> getAllCourses() {
		return courseList;
	}

	public Course getCourseByUrl(String url) {

		for (Course course : courseList) {
			if (course.getUrl().equals(url) && course.isAccepted()) {
				return course;
			}
		}
		return null;
	}
}
