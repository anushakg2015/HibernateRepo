package com.mk.hospital.service;

import java.util.List;

import com.mk.hospital.DAOimp.ObservationDAOImp;
import com.mk.hospital.dto.Observation;

public class ObservationService {
	public void saveObservation(int eid,Observation observation)
	{
		ObservationDAOImp daoimpl=new ObservationDAOImp();
		Observation observation1=daoimpl.saveObservation(eid, observation);
		if(observation1!=null)
		{
			System.out.println("Observations Saved");
		}
		else
		{
			System.out.println("Unfortunately data not found");
		}
	}
	public Observation getObservationById(int oid)
	{
		ObservationDAOImp daoimpl=new ObservationDAOImp();
		Observation observation=daoimpl.getObservationById(oid);
		if(observation!=null)
		{
			return observation;
		}
		else
		{
			return null;
		}
	}
	public void deleteObservationById(int oid)
	{
		ObservationDAOImp daoimpl=new ObservationDAOImp();
		boolean flag=daoimpl.DeleteObservationById(oid);
		if(flag)
		{
			System.out.println("Observations Deleted");
		}
		else
		{
			System.out.println("Observation Not Deleted");
		}
	}
	public Observation updateobservationById(int oid,Observation observation)
	{
		ObservationDAOImp daoimpl=new ObservationDAOImp();
		Observation observation1=daoimpl.updateObservationByid(oid);
		if(observation1!=null)
		{
			return observation1;
		}
		else
		{
			return null;
		}
	}

	public List<Observation> getAllObservation(int oid)
	{
		ObservationDAOImp daoimpl=new ObservationDAOImp();
		List<Observation> observation=daoimpl.getAllObservationById(oid);
		if(observation.size()>0) {
			return observation;
		}
		else
		{
			return null;
		}
	}
	public List<Observation> getAllObservationByDoctorName(String dname)
	{
		ObservationDAOImp daoimpl=new ObservationDAOImp();
		List<Observation> observation=daoimpl.getAllObservationByName(dname);
		return observation;
	}

}
