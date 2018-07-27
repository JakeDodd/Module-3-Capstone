package com.techelevator.npgeek.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.Model.DAOs.ParkDAO;
import com.techelevator.npgeek.Model.DAOs.SurveyDAO;
import com.techelevator.npgeek.Model.DAOs.WeatherDAO;
import com.techelevator.npgeek.Model.Objects.DailyWeather;
import com.techelevator.npgeek.Model.Objects.Park;
import com.techelevator.npgeek.Model.Objects.Survey;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private ParkDAO parkDao;
	
	@Autowired
	private WeatherDAO weatherDao;
	
	@Autowired
	private SurveyDAO surveyDao;
	
	private static final String CELSIUS = "C";
	private static final String FAHRENHEIT = "F";
	
	@RequestMapping(path = "/homepage", method = RequestMethod.GET)
	public String showHomePage(HttpServletRequest request) {
		List<Park> parkList = new ArrayList<Park>();
		parkList = parkDao.getAllParks();
		request.setAttribute("parkList", parkList);
		return "homepage";
		
	}
	
	@RequestMapping(path = "/detailpage", method = RequestMethod.GET)
	public String showDetailPage(HttpServletRequest request) {
		String parkCode = request.getParameter("parkcode");
		Park park = parkDao.getParkByCode(parkCode);
		
		request.getParameter("tempUnit");
		
		
		List<DailyWeather> fourDayForecast = weatherDao.getFiveDayForecastByPark(parkCode);
		DailyWeather todaysForecast = fourDayForecast.remove(0);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("todaysForecast", todaysForecast);
		session.setAttribute("park", park);
		session.setAttribute("fourDayForecast", fourDayForecast);
		
		return "detailpage";
	}

	@RequestMapping(path = "/detailpageCelcius", method = RequestMethod.GET)
	public String showDetailPageCelcius(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("tempUnit", checkForCorrectTempUnit(request.getParameter("tempUnit")));
		session.getAttribute("park");
		session.getAttribute("fourDayForecast");
		
		return "detailpage";
	}
	
	
	@RequestMapping(path = "/surveypage", method = RequestMethod.GET)
	public String showSurveyPage(HttpServletRequest request,Model survey) {
		if(!survey.containsAttribute("survey")){
			survey.addAttribute("survey",new Survey());
		}
		List<Park> parkList = new ArrayList<Park>();
		parkList = parkDao.getAllParks();
		request.setAttribute("parkList", parkList);
		return "surveypage";
		
	}
	
	@RequestMapping(path = "/surveypage", method = RequestMethod.POST)
	public String postSurvey(@Valid @ModelAttribute("survey") Survey survey,
			BindingResult result, RedirectAttributes flash) {
		if(result.hasErrors()) {
			flash.addFlashAttribute("survey", survey);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey",result);
			return "redirect:/surveypage";
		}
//	public String postSurveyPage(@RequestParam String parkcode, @RequestParam String email, @RequestParam String state, @RequestParam String activitylevel) {
//		Survey newSurvey = new Survey();
//		newSurvey.setParkCode(parkcode);
//		newSurvey.setEmail(email);
//		newSurvey.setState(state);
//		newSurvey.setActivityLevel(activitylevel);
//		surveyDao.saveSurvey(newSurvey);
		flash.addFlashAttribute("message","You have successfully submitted a survey");
		return "redirect:/favoritespage";
	}
	
	@RequestMapping(path = "/favoritespage", method=RequestMethod.GET) 
	public String showFavoritesPage(HttpServletRequest request) {
		
		Map<Park, Integer> favoriteParks = new LinkedHashMap<Park, Integer>();
		favoriteParks = surveyDao.getParkFavorites();
		
		request.setAttribute("favoriteParks", favoriteParks);
		return "favoritespage";
	}
	
	private String checkForCorrectTempUnit(String tempUnit) {
		String result = null;
		if(tempUnit.equalsIgnoreCase(CELSIUS)) {
			result = CELSIUS;
		} else {
			result = FAHRENHEIT;
		}
		return result;
	}
	
}
