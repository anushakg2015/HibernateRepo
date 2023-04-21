package com.mk.hospital.dao;

import com.mk.hospital.dto.Hospital;

public interface HospitalDao {
	public Hospital SaveHospital(Hospital hospital);
	public Hospital getHospital(int hid);
	public boolean deleteHospitalById(int hid);
	public Hospital updateHospitalById(int hid,Hospital hospital);

}
