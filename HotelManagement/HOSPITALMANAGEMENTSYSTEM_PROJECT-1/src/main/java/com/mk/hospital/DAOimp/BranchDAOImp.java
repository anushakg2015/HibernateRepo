package com.mk.hospital.DAOimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mk.hospital.dao.BranchDAO;
import com.mk.hospital.dto.Branch;
import com.mk.hospital.dto.Hospital;

public class BranchDAOImp implements BranchDAO{

	public Branch SaveBranch(Branch branch, int hid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital = entityManager.find(Hospital.class, hid);
		if(hospital != null) {
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			return branch;
		}
		else {
			return null;			
		}
	}

	public Branch getBranchById(int bid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch = entityManager.find(Branch.class, bid);

		if(branch != null) {
			return branch;
		}
		else {
			return null;	
		}
	}

	public boolean deleteBranchById(int bid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch = entityManager.find(Branch.class, bid);

		if(branch != null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		}

		else {
			return false;
		}

	}

	public Branch updateBranchById(int bid, Branch branch) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch1 = entityManager.find(Branch.class, bid);

		if(branch1 !=  null) {
			branch1.setName(branch.getName());
			branch1.setEmail(branch.getEmail());
			branch1.setPhn(branch.getPhn());
		

			entityTransaction.begin();
			entityManager.merge(branch1);
			entityTransaction.commit();
			return branch1;
		}
		else {
			return branch;
		}
	}

	public List<Branch> getAllBranchById(int bid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query =entityManager.createQuery("select b from Branch b");

		List<Branch>branchs=query.getResultList();

		return branchs;
	}

}
