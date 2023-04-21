package com.mk.hospital.service;

import com.mk.hospital.DAOimp.HospitalDaoImpl;
import com.mk.hospital.dto.Hospital;


public class HospitalService {
	public void saveHospitalService(Hospital hospital)
	{
		HospitalDaoImpl daoImpl=new HospitalDaoImpl();
		Hospital hospital2=daoImpl.SaveHospital(hospital);
		if(hospital2!=null) 
		{
			System.out.println("Hospital Saved");
		}
		else
		{
			System.out.println("Unfortunately data not found");
		}
	}
	public Hospital getHospital(int hid) {
		HospitalDaoImpl daoImpl=new HospitalDaoImpl();
		Hospital hospital3=daoImpl.getHospital(hid);
		if(hospital3!=null) 		{
			return hospital3;
		}
		else
		{
			return null;
		}
		
	}
	public void deleteHospitalById(int hid) {
		HospitalDaoImpl daoImpl=new HospitalDaoImpl();
		boolean flag=daoImpl.deleteHospitalById(hid);
		if(flag)
		{
			System.out.println("Hospital Deleted");
		}
		else
		{
			System.out.println("Hospital Not Deleted");
		}
		
		
		
	}
	public Hospital updateHospitalById(int hid, Hospital hospital) {
		HospitalDaoImpl daoImpl=new HospitalDaoImpl();
		Hospital hospital4=daoImpl.updateHospitalById(hid, hospital);
		if(hospital4!=null)
		{
			return hospital4;
		}
		else
		{
			return null;
		}
		
	}

}
