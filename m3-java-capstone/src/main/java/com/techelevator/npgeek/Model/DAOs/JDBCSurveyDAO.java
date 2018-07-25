package com.techelevator.npgeek.Model.DAOs;

import java.util.LinkedHashMap;
import java.util.Map;

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
	public Map<String, Integer> getParkFavorites() {
		Map<String, Integer> favoriteParks = new LinkedHashMap<String, Integer>();
		String sqlGetFavoriteParks = "SELECT count(*), parkcode FROM survey_result GROUP BY parkcode ORDER BY count DESC;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetFavoriteParks);
		while(result.next()) {
			favoriteParks.put("parkcode", Integer.parseInt("count"));
		}
		return favoriteParks;
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
