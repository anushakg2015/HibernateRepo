package com.mk.hospital.dao;

import java.util.List;

import com.mk.hospital.dto.Observation;

public interface ObservationDAO {
	public Observation saveObservation(int eid,Observation observation);
	public Observation getObservationById(int oid );
	public boolean DeleteObservationById(int oid);
	public Observation updateObservationByid(int oid);
	public List<Observation> getAllObservationById(int oid);
	public List<Observation> getAllObservationByName(String dname);
	

}
