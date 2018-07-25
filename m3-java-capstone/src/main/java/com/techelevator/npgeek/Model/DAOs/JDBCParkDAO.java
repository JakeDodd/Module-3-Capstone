package com.techelevator.npgeek.Model.DAOs;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.Model.Objects.Park;

public class JDBCParkDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> parksList = new ArrayList<Park>();
		String sqlGetAllParks = "SELECT * FROM park;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		while(result.next()) {
			parksList.add(mapRowToPark(result));
		}
		return parksList;
	}

	@Override
	public Park getParkByCode(int parkCode) {
		Park park;
		String sqlGetParkByCode = "SELECT * FROM park WHERE parkcode = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetParkByCode, parkCode);
		park = mapRowToPark(result);
		return park;
	}
	
	private Park mapRowToPark(SqlRowSet row) {
		Park park = new Park();
		park.setParkCode(row.getString("parkcode"));
		park.setParkName(row.getString("parkname"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getInt("acreage"));
		park.setElevation(row.getInt("elevationinfeet"));
		park.setMilesOfTrail(row.getFloat("milesoftrail"));
		park.setNumberOfCampsites(row.getInt("numberofcampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearFounded(row.getInt("yearfounded"));
		park.setAnnualVisitors(row.getInt("annualvisitorcount"));
		park.setInspirationalQuote(row.getString("inspirationalquote"));
		park.setQuoteSource(row.getString("inspirationalquotesource"));
		park.setDescription(row.getString("parkdescription"));
		park.setEntryFee(row.getInt("entryfee"));
		park.setNumberOfAnimalSpecies(row.getInt("numberofanimalspecies"));
		return park;
	}
}
