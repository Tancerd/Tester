package pl.tester.mvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.tester.model.Course;
import pl.tester.model.Exam;
import pl.tester.model.dto.QuestionDto;
import pl.tester.mvc.service.CoursesService;
import pl.tester.mvc.service.ExamsService;
import pl.tester.mvc.service.QuestionCheckerService;
import pl.tester.mvc.service.QuestionDtoGenerator;
import pl.tester.mvc.service.QuestionsService;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = { "/courses" })
public class QuestionLogicController {

	@Autowired private CoursesService coursesService;
	@Autowired private ExamsService examsService;
	@Autowired private QuestionsService questionsService;
	@Autowired private QuestionDtoGenerator questionDtoGenerator;
	@Autowired private QuestionCheckerService questionCheckerService;

	@RequestMapping(value = { "/{courseUrl}/{examUrl}" }, method = GET, params = {"count", "ajax"})
	public @ResponseBody String getQuestionList(@PathVariable String courseUrl,
			@PathVariable String examUrl, @RequestParam("count") int number) {

		Course course = coursesService.getCourseByUrl(courseUrl);
		Exam exam = examsService.getExamByUrl(course, examUrl);

		List<QuestionDto> questionList = questionDtoGenerator.generate(questionsService.getRandomQuestions(exam, number));

		Gson gson = new Gson();

		return gson.toJson(questionList);
	}

	@RequestMapping(value = { "/{courseUrl}/{examUrl}" }, method = POST, params = {"count", "ajax"})
	public @ResponseBody String checkQuestionList(@PathVariable String courseUrl,
			@PathVariable String examUrl, @RequestBody List<QuestionDto> questionDtoList) {

		Course course = coursesService.getCourseByUrl(courseUrl);
		Exam exam = examsService.getExamByUrl(course, examUrl);

		List<QuestionDto> result = questionCheckerService.check(exam.getQuestionList(), questionDtoList);

		Gson gson = new Gson();

		return gson.toJson(result);
	}
}
