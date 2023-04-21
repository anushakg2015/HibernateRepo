package com.mk.hospital.service;

import java.util.List;

import com.mk.hospital.DAOimp.MedicalOrderDAOimp;

import com.mk.hospital.dto.MedicalOrder;

public class MedicalOrderService {
	public void saveMedicalOrder(int bid,MedicalOrder encounters) {
		MedicalOrderDAOimp daOimp=new MedicalOrderDAOimp();
		MedicalOrder medicalOrder=daOimp.SaveMedicakOrderBYId(bid, encounters);
		if(medicalOrder!=null) {
			System.out.println("observation Saved");
		}
		else
		{
			System.out.println("unfortunitly data not found");
		}
	}
	public MedicalOrder getmedicMedicalOrderBYId(int mid) {
		MedicalOrderDAOimp daOimp=new MedicalOrderDAOimp();
		MedicalOrder medicalOrder1=daOimp.GetMedicakOrderBYId(mid);
		if(medicalOrder1!=null) {
			return medicalOrder1;
		}
		else
		{
			return null;
		}
		
	}
	public void deleteMedOrderById(int mid)
	{
		MedicalOrderDAOimp daOimp=new MedicalOrderDAOimp();
		boolean flag=daOimp.deleteMedicakOrderBYId(0);
		if(flag)
		{
			System.out.println("MedOrder Deleted");
		}
		else
		{
			System.out.println("MedOrder Not Deleted");
		}
	}
	public MedicalOrder updateMedOrderById(int mid,MedicalOrder medorder)
	{
		MedicalOrderDAOimp daOimp=new MedicalOrderDAOimp();
		MedicalOrder  medorder1=daOimp.UpdateMedicakOrderBYId(mid);
		if(medorder1!=null)
		{
			return medorder1;
		}
		else
		{
			return null;
		}
	}
	
	public List<MedicalOrder> getAllMedOrder(String date)
	{
		MedicalOrderDAOimp daOimp=new MedicalOrderDAOimp();
		List<MedicalOrder>  medorder=daOimp.getAllMedicalOrdersByDate(date);
		if(medorder.size()>0) {
			return medorder;
		}
		else
		{
			return null;
		}
	}
	public List<MedicalOrder> getMedOrderByDoctorName(String dname)
	{
		MedicalOrderDAOimp daOimp=new MedicalOrderDAOimp();
		List<MedicalOrder>  medorder=daOimp.getAllMedicalOrdersByDate(dname);
		return medorder;	
	}
	public List<MedicalOrder> getMedOrderByDate(String orderdate)
	{
		MedicalOrderDAOimp daOimp=new MedicalOrderDAOimp();
		List<MedicalOrder>  medorder=daOimp.getAllMedicalOrdersByDate(orderdate);
		return medorder;
	}
	

}
