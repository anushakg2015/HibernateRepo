package com.mk.hospital.DAOimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mk.hospital.dao.ItemDAO;
import com.mk.hospital.dto.Item;
import com.mk.hospital.dto.MedicalOrder;


public class itemDAOImp implements ItemDAO {

	public Item SaveItemByid(int mid, Item item) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
	
		MedicalOrder medorder = entityManager.find(MedicalOrder.class, mid);
		if(medorder != null) {
			entityTransaction.begin();
			entityManager.persist(medorder);
			entityTransaction.commit();
			return item;
		}
		else {
			return null;			
		}
	}

	public Item getItemById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Item item = entityManager.find(Item.class, id);
		
		if(item != null) {
			return item;
		}
		else {
			return null;	
		}
	}

	public boolean deletetemById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Item item = entityManager.find(Item.class, id);		
		if(item != null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Item updateItemById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Item item1 = entityManager.find(Item.class, id);
		
		if(item1 !=  null) {
			item1.setName(item1.getName());
			item1.setCost(item1.getCost());
			item1.setQuantity(item1.getQuantity());

			
			entityTransaction.begin();
			entityManager.merge(item1);
			entityTransaction.commit();
			return item1;
		}
		else {
			return item1;
		}
	}

	public List<Item> getAllItem() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Query query =entityManager.createQuery("select b from Item b");
		List<Item> items = query.getResultList();
		
		return items;
	}

	

}
