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
public class QuestionNumberChooserController {

	private final String VIEW_NAME = "question-number-chooser-view";

	@Autowired CoursesService coursesService;

	@RequestMapping(value = {"/{courseUrl}/{examUrl}"}, method = GET, params = "!count")
	public String showExamList(@PathVariable String courseUrl, @PathVariable String examUrl, 
									@ModelAttribute("model") ModelMap model) {

		return VIEW_NAME;
	}
}
