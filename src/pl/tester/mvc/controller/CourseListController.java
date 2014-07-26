package pl.tester.mvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.tester.mvc.service.CoursesService;


@Controller
@RequestMapping(value = {"/courses"})
public class CourseListController {

	private final String VIEW_NAME = "courses-list-view";

	@Autowired private CoursesService coursesService;

	@RequestMapping(method = GET)
	public String showCourseList(@ModelAttribute("model") ModelMap model) {

		model.addAttribute("courses", coursesService.getAllAcceptedCourses());

		return VIEW_NAME;
	}
}
