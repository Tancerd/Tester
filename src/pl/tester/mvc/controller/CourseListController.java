package pl.tester.mvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = {"/courses"})
public class CourseListController {

	@RequestMapping(value = "/list", method = GET)
	public String showCourseList(Model model) {
		
		return "courses-list-view";
	}
}
