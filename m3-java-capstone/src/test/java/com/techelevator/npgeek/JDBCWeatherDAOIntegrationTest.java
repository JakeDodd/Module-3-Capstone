package com.techelevator.npgeek;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.Model.DAOs.JDBCWeatherDAO;
import com.techelevator.npgeek.Model.Objects.DailyWeather;

public class JDBCWeatherDAOIntegrationTest {
	
	private static SingleConnectionDataSource dataSource;
	private JDBCWeatherDAO weatherDao;
	private static final String TEST_CODE = "GNP";

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
		weatherDao = new JDBCWeatherDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void returns_list_of_five_day_forecast() {
		List<DailyWeather> forecast = weatherDao.getFiveDayForecastByPark(TEST_CODE);
		
		Assert.assertNotNull(forecast);
		Assert.assertEquals(5, forecast.size());
	}
}
