package pl.tester.mvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.tester.model.Course;
import pl.tester.mvc.service.CoursesService;

@Controller
@RequestMapping("/course")
public class CourseEditController {

	private final String VIEW_NAME = "course-formular-view";

	@Autowired private CoursesService coursesService;

	@RequestMapping(method = GET)
	public String showAddCourseFormular(@ModelAttribute("model") ModelMap model) {

		model.addAttribute("command", new Course());

		return VIEW_NAME;
	}

	@RequestMapping(method = POST)
	public String addCourseFormular(@ModelAttribute("model") ModelMap model, 
									@ModelAttribute("course") Course course) {

		coursesService.saveOrUpdate(course);

		return VIEW_NAME;
	}
}
