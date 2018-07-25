package com.techelevator.npgeek.Model.DAOs;

import java.util.List;

import com.techelevator.npgeek.Model.Objects.Park;

public interface ParkDAO {

	public List<Park> getAllParks();
	public Park getParkByCode(int code);
}
