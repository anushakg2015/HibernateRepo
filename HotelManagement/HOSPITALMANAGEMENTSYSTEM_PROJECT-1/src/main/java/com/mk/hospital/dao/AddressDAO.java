package com.mk.hospital.dao;

import java.util.List;

import com.mk.hospital.dto.Address;

public interface AddressDAO {
	public Address saveAddress(int bid, Address address);
	public Address getAddressById(int aid);
	public boolean DeleteAddressById(int aid);
	public Address UpdateAddressById(int aid,Address address);
	public List<Address> getAllAdressById(int bid);
	
	
	

}
