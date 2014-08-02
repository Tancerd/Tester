package pl.tester.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.tester.mvc.service.CoursesService;

@Controller
@RequestMapping(value = {"/", "/home.*"})
public class HomeController {

	@Autowired private CoursesService coursesService;

	@RequestMapping
	public String showHomePage() {

		return "index";
	}
}
