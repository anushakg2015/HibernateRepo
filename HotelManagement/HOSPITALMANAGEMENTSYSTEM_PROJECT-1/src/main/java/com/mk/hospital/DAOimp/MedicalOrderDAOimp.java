package com.mk.hospital.DAOimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mk.hospital.dao.MedicalOrderDAO;
import com.mk.hospital.dto.Encounter;
import com.mk.hospital.dto.MedicalOrder;




public class MedicalOrderDAOimp implements MedicalOrderDAO{

	public MedicalOrder SaveMedicakOrderBYId(int eid, MedicalOrder medicalOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Encounter encounter=entityManager.find(Encounter.class,eid);
		if(encounter != null) {
			entityTransaction.begin();
			entityManager.persist(encounter);
			entityTransaction.commit();
			return medicalOrder;
		}
		else {
			return null;			
		}
	}
	

	public MedicalOrder GetMedicakOrderBYId(int mid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		MedicalOrder medOrder = entityManager.find(MedicalOrder.class, mid);
		
		if(medOrder != null) {
			return medOrder;
		}
		else {
			return null;	
		}
	}

	public boolean deleteMedicakOrderBYId(int mid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
	
		MedicalOrder medOrder = entityManager.find(MedicalOrder.class, mid);
		
		if(medOrder != null) {
			entityTransaction.begin();
			entityManager.remove(medOrder);
			entityTransaction.commit();
			return true;
		}
		
		else {
			return false;
		}
	}

	public MedicalOrder UpdateMedicakOrderBYId(int mid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
	
		MedicalOrder medOrder = entityManager.find(MedicalOrder.class, mid);
		if(medOrder != null) {
			medOrder.setDname(medOrder.getDname());
			medOrder.setOrderdate(medOrder.getOrderdate());
			medOrder.setTotal(medOrder.getTotal());
			
			entityTransaction.begin();
			entityManager.merge(medOrder);
			entityTransaction.commit();
			return medOrder;
		}
		else {
			return medOrder;
		}
	}


	public List<MedicalOrder> getAllMedicalOrdersById(int mid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Query query =entityManager.createQuery("select b from MedOrder b");
		
		List<MedicalOrder> medOrder = query.getResultList();
		return medOrder;
	}


	public List<MedicalOrder> getAllMedicalOrdersByName(String name) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Query query =entityManager.createQuery("select b from MedOrder b where b.name=?1");
		query.setParameter(1, "dname");
		
		List<MedicalOrder> medOrders = query.getResultList();
		
		return medOrders;
	}


	public List<MedicalOrder> getAllMedicalOrdersByDate(String date) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Query query =entityManager.createQuery("select b from MedOrder b where b.name=?1");
		query.setParameter(1, "dname");
		
		List<MedicalOrder> medOrders = query.getResultList();
		
		return medOrders;
	}

	

	

}
