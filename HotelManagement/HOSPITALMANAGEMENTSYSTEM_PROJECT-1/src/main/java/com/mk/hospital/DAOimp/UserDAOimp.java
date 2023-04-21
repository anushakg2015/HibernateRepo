package com.mk.hospital.DAOimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mk.hospital.dao.UserDAO;
import com.mk.hospital.dto.User;

public class UserDAOimp implements UserDAO{

	public User saveUser(User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	public User getUserByid(int uid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		User user= entityManager.find(User.class, uid);
		if(user!=null)
		{
			return user;
		}
		else
		{
			return null;
		}
	}

	public boolean deleteUserByid(int uid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		User user= entityManager.find(User.class, uid);
		if(user!=null)
		{
			entityTransaction.begin();
			entityManager.persist(user);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}
	}

	public User UpdateUserById(int uid, User User) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		User user1= entityManager.find(User.class, uid);
		if(user1!=null)
		{
			user1.setName(User.getName());
			user1.setEmail(User.getEmail());
			user1.setPhn(User.getPhn());
			user1.setPassword(User.getPassword());
			user1.setRole(User.getRole());
			
			entityTransaction.begin();
			entityManager.merge(user1);
			entityTransaction.commit();
			return user1;
		}
		else
		{
			return User;
		}
	}

	public List<User> getAllUser() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select u from User u ");
		List<User> user=query.getResultList();
		return null;
	}

	public List<User> getUserByRole(String role) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select u from User u where u.role=?1 ");
		query.setParameter(1, role);
		
		List<User> user=query.getResultList();
		
		return user;
	}

	

}
