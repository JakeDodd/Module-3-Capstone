package com.techelevator.npgeek.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

	@RequestMapping(path = "/homepage", method = RequestMethod.GET)
	public String showHomePage() {

		return "homepage";

	}

	@RequestMapping(path = "/surveypage", method = RequestMethod.GET)
	public String showSurveyPage() {
		
		return "surveypage";
	}
	
}
