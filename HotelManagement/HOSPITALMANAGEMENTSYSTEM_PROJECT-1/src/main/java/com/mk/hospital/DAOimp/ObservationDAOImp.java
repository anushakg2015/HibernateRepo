package com.mk.hospital.DAOimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mk.hospital.dao.ObservationDAO;
import com.mk.hospital.dto.Encounter;
import com.mk.hospital.dto.Observation;


public class ObservationDAOImp implements ObservationDAO{

	public Observation saveObservation(int eid, Observation observation) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Encounter encounter = entityManager.find(Encounter.class, eid);
		if(encounter != null) {
			entityTransaction.begin();
			entityManager.persist(observation);;
			entityTransaction.commit();
			return observation;
		}
		else {
			return null;			
		}
	}

	public Observation getObservationById(int oid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Observation observation = entityManager.find(Observation.class, oid);

		if(observation != null) {
			return observation;
		}
		return null;
	}

	public boolean DeleteObservationById(int oid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Observation observation = entityManager.find(Observation.class, oid);

		if(observation != null) {
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return true;
		}

		else {
			return false;
		}
	}

	public Observation updateObservationByid(int oid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Observation observation = entityManager.find(Observation.class, oid);

		if(observation != null) {
			observation.setDname(observation.getDname());
			observation.setReobservation(observation.getReobservation());
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return observation;
		}
		else {
			return observation;
		}
	}

	public List<Observation> getAllObservationById(int oid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query =entityManager.createQuery("select b from Observation b");
		List<Observation> observations = query.getResultList();
		return observations;
	}

	public List<Observation> getAllObservationByName(String dname) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query =entityManager.createQuery("select b from Observation b where b.dname=?1");
		query.setParameter(1, "dname");
		List<Observation> observations = query.getResultList();
		return observations;
	}

	

}
