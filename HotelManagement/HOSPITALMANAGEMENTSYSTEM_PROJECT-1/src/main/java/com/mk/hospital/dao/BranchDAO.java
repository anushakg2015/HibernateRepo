package com.mk.hospital.dao;

import java.util.List;

import com.mk.hospital.dto.Branch;

public interface BranchDAO {
           public Branch SaveBranch(Branch branch,int hid);
           public Branch getBranchById(int bid);
           public boolean deleteBranchById(int bid);
           public Branch updateBranchById(int bid,Branch branch);
           public List<Branch> getAllBranchById(int bid);
}
