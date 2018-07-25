package com.techelevator.npgeek.Model.DAOs;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.Model.Objects.Survey;

public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveys = new ArrayList<Survey>();
		String sqlGetAllSurveys = "SELECT * FROM survey_result;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetAllSurveys);
		while (result.next()) {
			allSurveys.add(mapRowToSurvey(result));
		}
		return allSurveys;
	}

	@Override
	public void saveSurvey(Survey survey) {
		String sqlInsertSurvey = "INSERT INTO survey_result (parkcode,emailaddress,state,activitylevel) VALUES (?,?,?,?);";
		jdbcTemplate.update(sqlInsertSurvey, survey.getParkCode(), survey.getEmail(), survey.getState(),
				survey.getActivityLevel());

	}

	private Survey mapRowToSurvey(SqlRowSet result) {
		Survey survey = new Survey();
		survey.setParkCode(result.getString("parkcode"));
		survey.setEmail(result.getString("emailaddress"));
		survey.setState(result.getString("state"));
		survey.setActivityLevel(result.getString("activitylevel"));
		return survey;

	}

}
