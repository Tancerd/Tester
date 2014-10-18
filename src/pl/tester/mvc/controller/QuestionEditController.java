package pl.tester.mvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.tester.model.Course;
import pl.tester.model.Exam;
import pl.tester.model.Question;
import pl.tester.model.dto.QuestionDto;
import pl.tester.mvc.service.CoursesService;
import pl.tester.mvc.service.ExamsService;
import pl.tester.mvc.service.QuestionDtoGenerator;

@Controller
@RequestMapping(value={"/add"})
public class QuestionEditController {

	private final String VIEW_NAME = "question-formular-view";

	@Autowired private CoursesService coursesService;
	@Autowired private ExamsService examsService;
	@Autowired private QuestionDtoGenerator questionDtoGenerator;

	@RequestMapping(value = "/{courseUrl}/{examUrl}", method = GET)
	public String showAddCourseFormular(@ModelAttribute("model") ModelMap model) {
		return VIEW_NAME;
	}

	@RequestMapping(value = "/{courseUrl}/{examUrl}", method = POST, consumes = {"application/json"})
	public String addExamFormular(@RequestBody QuestionDto questionDto, 
									@PathVariable String courseUrl, 
									@PathVariable String examUrl) {

		Course course = coursesService.getCourseByUrl(courseUrl);
		Exam exam = examsService.getExamByUrl(course, examUrl);

		Question question = questionDtoGenerator.generateBack(questionDto);
		question.setExam(exam);
		
		exam.getQuestionList().size();
		exam.getQuestionList().add(question);

		coursesService.saveOrUpdate(course);

		return VIEW_NAME;
	}
}
