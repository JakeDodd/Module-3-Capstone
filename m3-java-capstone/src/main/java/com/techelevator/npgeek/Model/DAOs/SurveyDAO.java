package com.techelevator.npgeek.Model.DAOs;

import java.util.List;

import com.techelevator.npgeek.Model.Objects.Survey;

public interface SurveyDAO {

	public List<Survey> getAllSurveys();
	public void saveSurvey(Survey survey);
}
