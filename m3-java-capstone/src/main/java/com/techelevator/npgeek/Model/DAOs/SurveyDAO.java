package com.techelevator.npgeek.Model.DAOs;

import java.util.Map;

import com.techelevator.npgeek.Model.Objects.Survey;

public interface SurveyDAO {

	public Map<String, Integer> getParkFavorites();
	public void saveSurvey(Survey survey);
}
