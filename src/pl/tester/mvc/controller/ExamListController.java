package pl.tester.mvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.tester.mvc.service.CoursesService;

@Controller
@RequestMapping(value = {"/courses"})
public class ExamListController {

	@Autowired CoursesService coursesService;

	@RequestMapping(value = {"/{courseUrl}"}, method = GET)
	public String showExamList(@PathVariable String courseUrl, @ModelAttribute("model") ModelMap model) {

		model.addAttribute("course", coursesService.getCourseByUrl(courseUrl));

		return "exams-list-view";
	}
}
