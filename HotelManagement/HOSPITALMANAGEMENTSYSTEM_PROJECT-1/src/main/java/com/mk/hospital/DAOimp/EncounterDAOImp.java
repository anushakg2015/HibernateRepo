package com.mk.hospital.DAOimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mk.hospital.dao.EncounterDao;
import com.mk.hospital.dto.Branch;
import com.mk.hospital.dto.Encounter;

public class EncounterDAOImp implements EncounterDao{

	public Encounter SaveEncounter(int bid, Encounter encounters) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Branch branch=entityManager.find(Branch.class,bid);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			return encounters;
		}
		else
		{
			return null;
		}
		
		
	}

	public Encounter getEncounterById(int eid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			return encounter;
		}
		else {
		return null;
		}
	}

	public boolean DeleteEncounterById(int eid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			return true;
		}
		else
		{
		 
		return false;
		}
	}
	

	public Encounter UpdateEncounterById(int eid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Encounter encounter1=entityManager.find(Encounter.class, eid);
		if(encounter1!=null) {
			encounter1.setDateofjoin(encounter1.getDateofjoin());
			encounter1.setDischarge(encounter1.getDischarge());
			
			entityTransaction.begin();
			entityManager.merge(encounter1);
			entityTransaction.commit();
			return encounter1;
		}
		else
		{
		
		return null;
		}
	}

	public List<Encounter> GetAllEncounterById(int bid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select b from Encounter b");
		return null;
	}

	

}
