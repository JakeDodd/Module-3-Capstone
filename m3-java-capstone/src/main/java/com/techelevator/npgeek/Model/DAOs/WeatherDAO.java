package com.techelevator.npgeek.Model.DAOs;

import java.util.List;

import com.techelevator.npgeek.Model.Objects.DailyWeather;

public interface WeatherDAO {

	public List<DailyWeather> getFiveDayForecastByPark(String code);
}
