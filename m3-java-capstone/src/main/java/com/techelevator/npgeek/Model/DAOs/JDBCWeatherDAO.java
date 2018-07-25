package com.techelevator.npgeek.Model.DAOs;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.Model.Objects.DailyWeather;

public class JDBCWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<DailyWeather> getFiveDayForecastByPark(int parkCode) {
		List<DailyWeather> fiveDayForecast = new ArrayList<DailyWeather>();
		String sqlWeatherQuery = "SELECT * FROM weather WHERE parkcode = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlWeatherQuery, parkCode);
		while(result.next()) {
			fiveDayForecast.add(mapRowToDailyWeather(result));
		}
		return fiveDayForecast;
	}
	
	private DailyWeather mapRowToDailyWeather(SqlRowSet result) {
		DailyWeather dailyWeather = new DailyWeather();
		dailyWeather.setDay(result.getInt("fivedayforecastvalue"));
		dailyWeather.setLowTemp(result.getInt("low"));
		dailyWeather.setHighTemp(result.getInt("high"));
		dailyWeather.setForecast(result.getString("forecast"));
		return dailyWeather;
	}
}
