package pl.tester.mvc.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.tester.model.Course;

@Repository
public class CoursesRepository {

	@Autowired private SessionFactory sessionFactory;

	/*
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
				exam.setUrl(exam.getTitle().replace(" ", "_").toLowerCase());
				exam.setAccepted(true);
				List <Question> questions = new ArrayList<>();
				for (int k = 0; k < 3; k++) {
					Question question = new Question();
					question.setAccepted(true);
					question.setAuthor("Me");
					question.setText("Do i like it?");
					List<Answer> answers = new ArrayList<>();
					for (int m = 0; m < 4; m++) {
						Answer answer = new Answer();
						answer.setText("Answer " + (m+1));
						answers.add(answer);
					}
					question.setAnswerList(answers);
					questions.add(question);
				}
				exam.setQuestionList(questions);
				exams.add(exam);
			}
			course.setExamList(exams);
			courseList.add(course);
		}
	}
	*/

	public void saveOrUpdate(Course course) {
		sessionFactory.getCurrentSession().save(course);
	}

	public List<Course> getAllCourses() {
		return sessionFactory.getCurrentSession().createCriteria(Course.class).list();
	}

	public Course getCourseByUrl(String url) {

		for (Course course : getAllCourses()) {
			if (course.getUrl().equals(url) && course.isAccepted()) {
				return course;
			}
		}
		return null;
	}
}
