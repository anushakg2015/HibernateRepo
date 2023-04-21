package com.mk.controol;


import com.mk.hospital.dto.Address;
import com.mk.hospital.dto.Branch;
import com.mk.hospital.dto.Hospital;
import com.mk.hospital.service.AddressService;
import com.mk.hospital.service.BranchServices;
import com.mk.hospital.service.HospitalService;

public class TestSaveHospital {
public static void main(String[] args) {
	Hospital hospital=new Hospital();
	HospitalService service=new HospitalService();
	hospital.setHname("Jayadev");
	hospital.setWebsite("www.javadev.hospital.com");
	service.saveHospitalService(hospital);
	Address address=new Address();
	AddressService service1=new AddressService();
	address.setStreet("talikoti");
	address.setState("Karnataka");
	address.setCountry("India");
	address.setPincode(586245);
	
	service1.saveAddress(1, address);
	Branch branch=new Branch();
	BranchServices services12=new BranchServices();
	branch.setAddress(address);
	branch.setEmail("www.bid@gamil.com");
	branch.setHospital(hospital);
	branch.setName("talikoti");
	services12.getBranchById(1);
	
	
	
	
	
}
}
