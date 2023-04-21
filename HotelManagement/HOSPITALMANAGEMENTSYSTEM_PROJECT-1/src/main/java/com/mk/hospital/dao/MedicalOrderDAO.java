package com.mk.hospital.dao;

import java.util.List;

import com.mk.hospital.dto.MedicalOrder;

public interface MedicalOrderDAO {
	public MedicalOrder SaveMedicakOrderBYId(int eid,MedicalOrder medicalOrder);
	public MedicalOrder GetMedicakOrderBYId(int mid);
	public boolean deleteMedicakOrderBYId(int mid);
	public MedicalOrder UpdateMedicakOrderBYId(int mid);
	public List<MedicalOrder> getAllMedicalOrdersById(int mid);
	public List<MedicalOrder> getAllMedicalOrdersByName(String name);
	public List<MedicalOrder> getAllMedicalOrdersByDate(String date);

}
