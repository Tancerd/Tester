package pl.tester.mvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.tester.model.Course;
import pl.tester.model.Exam;
import pl.tester.mvc.service.CoursesService;

@Controller
@RequestMapping("/add")
public class ExamEditController {

	private final String VIEW_NAME = "exam-formular-view";

	@Autowired private CoursesService coursesService;

	@RequestMapping(value = "/{courseUrl}", method = GET)
	public String showAddCourseFormular(@ModelAttribute("model") ModelMap model) {
		return VIEW_NAME;
	}

	@RequestMapping(value = "/{courseUrl}", method = POST)
	public String addExamFormular(@ModelAttribute("model") ModelMap model, 
									@ModelAttribute("exam") Exam exam, 
									@PathVariable String courseUrl) {

		Course course = coursesService.getCourseByUrl(courseUrl);
		exam.setCourse(course);
		exam.setUpUrl();
		exam.setDateCreate(new Date());

		course.getExamList().add(exam);

		coursesService.saveOrUpdate(course);

		return VIEW_NAME;
	}
}
