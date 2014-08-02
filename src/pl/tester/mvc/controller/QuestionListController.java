package pl.tester.mvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = {"/courses"})
public class QuestionListController {

	private final String VIEW_NAME = "questions-list-view";

	@RequestMapping(value = {"/{courseUrl}/{examUrl}"}, method = GET, params = "count")
	public String showQuestionList(@PathVariable String courseUrl, @PathVariable String examUrl, 
								@RequestParam("count") int number, @ModelAttribute("model") ModelMap model) {

		return VIEW_NAME;
	}
}
