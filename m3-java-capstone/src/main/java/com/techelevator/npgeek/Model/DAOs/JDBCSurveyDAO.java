package com.techelevator.npgeek.Model.DAOs;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Model.Objects.Park;
import com.techelevator.npgeek.Model.Objects.Survey;
@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Map<Park, Integer> getParkFavorites() {
		Map<Park, Integer> favoriteParks = new LinkedHashMap<Park, Integer>();
		String sqlGetFavoriteParks = "SELECT count(*), survey_result.parkcode, park.parkname FROM survey_result "
				+ "LEFT JOIN park ON survey_result.parkcode = park.parkcode "
				+ "GROUP BY survey_result.parkcode, park.parkname ORDER BY count DESC;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetFavoriteParks);
		while(result.next()) {
			Park favPark = mapRowToFavoritePark(result);
			favoriteParks.put(favPark, result.getInt("count"));
		}
		return favoriteParks;
	}

	@Override
	public void saveSurvey(Survey survey) {
		String sqlInsertSurvey = "INSERT INTO survey_result (parkcode,emailaddress,state,activitylevel) VALUES (?,?,?,?);";
		jdbcTemplate.update(sqlInsertSurvey, survey.getParkCode(), survey.getEmail(), survey.getState(),
				survey.getActivityLevel());

	}

	private Park mapRowToFavoritePark(SqlRowSet result) {
		Park favPark = new Park();
		favPark.setParkCode(result.getString("parkcode"));
		favPark.setParkName(result.getString("parkname"));
		return favPark;
	}

}
