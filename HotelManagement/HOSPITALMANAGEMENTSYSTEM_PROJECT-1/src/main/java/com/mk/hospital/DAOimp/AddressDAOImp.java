package com.mk.hospital.DAOimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mk.hospital.dao.AddressDAO;
import com.mk.hospital.dto.Address;
import com.mk.hospital.dto.Branch;

public class AddressDAOImp implements AddressDAO {

	public Address saveAddress(int bid, Address address) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch = entityManager.find(Branch.class, bid);
		
		if(branch != null) {
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
			return address;
		}
		else
		{
		
		
		return null;
		}
	}

	public Address getAddressById(int aid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Address address = entityManager.find(Address.class, aid);

		if(address != null) {
			return address;
		}
		else {
			return null;	
		}
	}

	public boolean DeleteAddressById(int aid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Address address = entityManager.find(Address.class, aid);

		if(address != null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Address UpdateAddressById(int aid, Address address) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Address address1 = entityManager.find(Address.class, aid);

		if(address1 != null) {
			address1.setStreet(address.getStreet());
			address1.setState(address.getState());
			address1.setCountry(address.getCountry());
			address1.setAid(address.getPincode());
			return address1;
		}
		else {
			return address;
		}
	}

	public List<Address> getAllAdressById(int bid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("select a from Address b");

		List<Address> address = query.getResultList();

		return address;
	}

	

}
