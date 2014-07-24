package pl.tester.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.tester.model.Course;
import pl.tester.model.Exam;
import pl.tester.mvc.repository.ExamsRepository;

@Service
public class ExamsService {

	//@Autowired ExamsRepository examsRepository;

	public List<Exam> getAllExamsForCourse(Course course) {
		return course.getExamList();
	}
}
