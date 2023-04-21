package com.mk.hospital.DAOimp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mk.hospital.dao.HospitalDao;
import com.mk.hospital.dto.Hospital;

public class HospitalDaoImpl implements HospitalDao {

	public Hospital SaveHospital(Hospital hospital) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
		return hospital;
	}

	public Hospital getHospital(int hid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital= entityManager.find(Hospital.class, hid);
		if(hospital!=null)
		{
			return hospital;
		}
		else
		{
			return null;
		}
	}

	public boolean deleteHospitalById(int hid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital= entityManager.find(Hospital.class, hid);
		if(hospital!=null)
		{
			entityTransaction.begin();
			entityManager.persist(hospital);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}
	}

	public Hospital updateHospitalById(int hid, Hospital hospital) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital1= entityManager.find(Hospital.class, hid);
		if(hospital1!=null)
		{
			hospital1.setHname(hospital.getHname());
			hospital1.setWebsite(hospital.getWebsite());
			entityTransaction.begin();
			entityManager.merge(hospital1);
			entityTransaction.commit();
			return hospital1;
		}
		else
		{
			return hospital;
		}
	}

}
