package com.mk.hospital.dao;

import java.util.List;

import com.mk.hospital.dto.Encounter;

public interface EncounterDao {
	
	public Encounter SaveEncounter(int bid,Encounter encounters);
	public Encounter getEncounterById(int eid);
	public boolean DeleteEncounterById(int eid);
	public Encounter UpdateEncounterById(int eid);
	public  List<Encounter> GetAllEncounterById(int eid);

}
