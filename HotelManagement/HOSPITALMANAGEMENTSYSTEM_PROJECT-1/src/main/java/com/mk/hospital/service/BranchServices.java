package com.mk.hospital.service;

import com.mk.hospital.DAOimp.BranchDAOImp;
import com.mk.hospital.dao.BranchDAO;
import com.mk.hospital.dto.Branch;

public class BranchServices {
	
	
	public Branch getBranchById(int bid) {
		BranchDAO daoimp=new BranchDAOImp();
		Branch branch=daoimp.getBranchById(bid);
		if(branch!=null) {
			return branch;
		}
		else
		{
			return null;
		}
		
	}
	public void DeleteBranchById(int bid) {
		BranchDAO daoimp=new BranchDAOImp();
		boolean flag=daoimp.deleteBranchById(bid);
		if(flag) {
			System.out.println("Branch deleted");
		}
		else
		{
			System.out.println("branch not deleted");
		}
		
	}
	public Branch updaBranch(int bid,Branch branch) {
		BranchDAO daoimp=new BranchDAOImp();
		Branch branch1=daoimp.updateBranchById(bid, branch);
		if(branch!=null) {
			return branch;
		}
		else
		{
			return null;
		}
	}

}
