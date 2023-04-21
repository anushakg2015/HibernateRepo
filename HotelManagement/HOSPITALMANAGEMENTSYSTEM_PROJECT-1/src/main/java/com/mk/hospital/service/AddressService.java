package com.mk.hospital.service;

import java.util.List;

import com.mk.hospital.DAOimp.AddressDAOImp;
import com.mk.hospital.dto.Address;

public class AddressService{
	public void saveAddress(int bid,Address address)
	{
		AddressDAOImp addressDAOImp=new AddressDAOImp();
		Address address1=addressDAOImp.saveAddress(bid, address);
		if(address1!=null)
		{
			System.out.println("Address Saved");
		}
		else
		{
			System.out.println("Unfortunately data not found");
		}
		
	}
	public void deleteAddressById(int aid)
	{
		AddressDAOImp addressDAOImp=new AddressDAOImp();
		boolean flag=addressDAOImp.DeleteAddressById(aid);
		if(flag)
		{
			System.out.println("Address Deleted");
		}
		else
		{
			System.out.println("Address Not Deleted");
		}
	}
	public Address getAddressById(int aid)
	{
		AddressDAOImp addressDAOImp=new AddressDAOImp();
		Address address=addressDAOImp.getAddressById(aid);
		if(address!=null)
		{
			return address;
		}
		else
		{
			return null;
		}
	}
	public Address updateAddressById(int aid,Address address)
	{
		AddressDAOImp addressDAOImp=new AddressDAOImp();
		Address address1=addressDAOImp.UpdateAddressById(aid, address);
		if(address1!=null)
		{
			return address1;
		}
		else
		{
			return null;
		}
	}
	
	public List<Address> getAllAddress(int aid)
	{
		AddressDAOImp addressDAOImp=new AddressDAOImp();
		List<Address> address=addressDAOImp.getAllAdressById(aid);
		if(address.size()>0) {
			return address;
		}
		else
		{
			return null;
		}
	}
	
	

}
