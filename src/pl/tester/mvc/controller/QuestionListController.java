package pl.tester.mvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.tester.model.Course;
import pl.tester.model.Exam;
import pl.tester.mvc.service.CoursesService;
import pl.tester.mvc.service.ExamsService;
import pl.tester.mvc.service.QuestionsService;

@Controller
@RequestMapping(value = {"/courses"})
public class QuestionListController {

	private final String VIEW_NAME = "questions-list-view";

	@Autowired CoursesService coursesService;
	@Autowired ExamsService examsService;
	@Autowired QuestionsService questionsService;

	@RequestMapping(value = {"/{courseUrl}/{examUrl}"}, method = GET, params = "count")
	public String showQuestionList(@PathVariable String courseUrl, @PathVariable String examUrl, 
								@RequestParam("count") int number, @ModelAttribute("model") ModelMap model) {

		Course course = coursesService.getCourseByUrl(courseUrl);
		Exam exam = examsService.getExamByUrl(course, examUrl);
		model.addAttribute("questions", questionsService.getRandomQuestions(exam, number));

		return VIEW_NAME;
	}
}
