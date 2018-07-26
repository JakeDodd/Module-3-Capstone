package com.techelevator.npgeek.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

@Controller
public class HomeController {

	@Autowired
	private ParkDAO parkDao;
	
	@Autowired
	private WeatherDAO weatherDao;
	
	@Autowired
	private SurveyDAO surveyDao;
	
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
		request.setAttribute("park", park);
		
		List<DailyWeather> fiveDayForecast = weatherDao.getFiveDayForecastByPark(parkCode);
		request.setAttribute("fiveDayForecast", fiveDayForecast);
		
		HttpSession session = request.getSession();
		session.setAttribute("tempUnit", request.getParameter("tempUnit"));
		
		return "detailpage";
	}

	@RequestMapping(path = "/surveypage", method = RequestMethod.GET)
	public String showSurveyPage(HttpServletRequest request) {
		List<Park> parkList = new ArrayList<Park>();
		parkList = parkDao.getAllParks();
		request.setAttribute("parkList", parkList);
		return "surveypage";
		
	}
	
	@RequestMapping(path = "/surveypage", method = RequestMethod.POST)
	public String postSurveyPage(@RequestParam String parkcode, @RequestParam String email, @RequestParam String state, @RequestParam String activitylevel) {
		Survey newSurvey = new Survey();
		newSurvey.setParkCode(parkcode);
		newSurvey.setEmail(email);
		newSurvey.setState(state);
		newSurvey.setActivityLevel(activitylevel);
		surveyDao.saveSurvey(newSurvey);
		return "redirect:/favoritespage";
	}
	
	@RequestMapping(path = "/favoritespage", method=RequestMethod.GET) 
	public String showFavoritesPage(HttpServletRequest request) {
		Map<String, Integer> surveyCount = new LinkedHashMap<String, Integer>();
		Map<Park, Integer> favoriteParks = new LinkedHashMap<Park, Integer>();
		surveyCount = surveyDao.getParkFavorites();
		for(Map.Entry<String, Integer> entry : surveyCount.entrySet()) {
			favoriteParks.put(parkDao.getParkByCode(entry.getKey()), entry.getValue());
		}
		request.setAttribute("favoriteParks", favoriteParks);
		return "favoritespage";
	}
	
}
