package pl.tester.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/home.*"})
public class HomeController {

	@RequestMapping
	public String showHomePage() {
		return "index";
	}
}
