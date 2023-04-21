package com.mk.hospital.service;

import java.util.List;

import com.mk.hospital.DAOimp.EncounterDAOImp;
import com.mk.hospital.dto.Encounter;

public class EncountersService {
	public void saveEncounter(int bid,Encounter encounter)
	{
		EncounterDAOImp daoimpl=new EncounterDAOImp();
		Encounter encounter1=daoimpl.SaveEncounter(bid, encounter);
		if(encounter1!=null)
		{
			System.out.println("Encounter Saved");
		}
		else
		{
			System.out.println("Unfortunately data not found");
		}
		
		
	}
	public Encounter getEncounterById(int eid)
	{
		EncounterDAOImp daoimpl=new EncounterDAOImp();
		Encounter encounter=daoimpl.getEncounterById(eid);
		if(encounter!=null)
		{
			return encounter;
		}
		else
		{
			return null;
		}
	}
	public void deleteEncounterById(int eid)
	{
		EncounterDAOImp daoimpl=new EncounterDAOImp();
		boolean flag=daoimpl.DeleteEncounterById(eid);
		if(flag)
		{
			System.out.println("Encounter Deleted");
		}
		else
		{
			System.out.println("Encounter Not Deleted");
		}
	}
	public Encounter updateEncounterById(int eid,Encounter encounter)
	{
		EncounterDAOImp daoimpl=new EncounterDAOImp();
		Encounter encounter1=daoimpl.UpdateEncounterById(eid);
		if(encounter1!=null)
		{
			return encounter1;
		}
		else
		{
			return null;
		}
	}

	public List<Encounter> getAllEncounter(int eid)
	{
		EncounterDAOImp daoimpl=new EncounterDAOImp();
		List<Encounter> encounter=daoimpl.GetAllEncounterById(eid);
		if(encounter.size()>0) {
			return encounter;
		}
		else
		{
			return null;
		}
	}

}
