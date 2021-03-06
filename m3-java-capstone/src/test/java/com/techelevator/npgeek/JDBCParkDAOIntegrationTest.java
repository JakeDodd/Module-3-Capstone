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

import com.techelevator.npgeek.Model.DAOs.JDBCParkDAO;
import com.techelevator.npgeek.Model.Objects.Park;

public class JDBCParkDAOIntegrationTest {

	private static SingleConnectionDataSource dataSource;
	private JDBCParkDAO parkDao;
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
		parkDao = new JDBCParkDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void returns_list_of_parks() {
		List<Park> parks = parkDao.getAllParks();
		
		Assert.assertNotNull(parks);
		Assert.assertEquals(10, parks.size());
	}
	
	@Test
	public void return_park_when_given_park_code() {
		Park testPark = parkDao.getParkByCode(TEST_CODE);
		
		Assert.assertNotNull(testPark);
		Assert.assertEquals("Glacier National Park", testPark.getParkName());
	}
}
