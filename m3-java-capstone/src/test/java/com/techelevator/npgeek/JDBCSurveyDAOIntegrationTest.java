package com.techelevator.npgeek;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.Model.DAOs.JDBCSurveyDAO;
import com.techelevator.npgeek.Model.Objects.Park;
import com.techelevator.npgeek.Model.Objects.Survey;

import org.junit.Assert;

public class JDBCSurveyDAOIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	private JDBCSurveyDAO surveyDao;
	private static final String TEST_CODE = "GNP";
	private static final String TEST_STATE = "XY";
	private static Survey survey;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setAutoCommit(false);
		
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		surveyDao = new JDBCSurveyDAO(dataSource);
		survey = new Survey();
		survey.setParkCode(TEST_CODE);
		survey.setEmail("test@email");
		survey.setState(TEST_STATE);
		survey.setActivityLevel("pro-golfer");
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void save_new_survey() {
		surveyDao.saveSurvey(survey);
		
		assertSurveysAreEqual(survey, getSurveyByState(TEST_STATE));
	}
	
	@Test
	public void get_favorite_parks_list() {
		Map<Park, Integer> favoriteParks = new LinkedHashMap<Park, Integer>();
		favoriteParks = surveyDao.getParkFavorites();
		
		Assert.assertNotNull(favoriteParks);
	}
	
	private void assertSurveysAreEqual(Survey expected, Survey actual) {
		Assert.assertEquals(expected.getParkCode(), actual.getParkCode());
		Assert.assertEquals(expected.getEmail(), actual.getEmail());
		Assert.assertEquals(expected.getActivityLevel(), actual.getActivityLevel());
		Assert.assertEquals(expected.getState(), actual.getState());
	}
	
	private Survey getSurveyByState(String state) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Survey survey = new Survey();
		String sqlGetSurvey = "SELECT * FROM survey_result WHERE state = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetSurvey, state);
		while(result.next()) {
			survey.setParkCode(result.getString("parkcode"));
			survey.setState(result.getString("state"));
			survey.setEmail(result.getString("emailaddress"));
			survey.setActivityLevel(result.getString("activitylevel"));
		}
		return survey;
	}
	
}
