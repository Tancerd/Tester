package pl.tester.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.tester.model.Course;
import pl.tester.model.Exam;

@Service
public class ExamsService {

	public List<Exam> getAllExamsForCourse(Course course) {
		return course.getExamList();
	}

	public Exam getExamByUrl(Course course, String examUrl) {

		for (Exam exam : getAllExamsForCourse(course)) {
			if (exam.getUrl().equals(examUrl) && exam.isAccepted()) {
				return exam;
			}
		}

		return null;
	}
}
