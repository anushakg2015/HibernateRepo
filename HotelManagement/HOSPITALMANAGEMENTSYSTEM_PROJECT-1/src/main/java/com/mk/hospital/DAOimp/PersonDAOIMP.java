package com.mk.hospital.DAOimp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mk.hospital.dao.PersonDAO;
import com.mk.hospital.dto.Encounter;
import com.mk.hospital.dto.Person;


public class PersonDAOIMP implements PersonDAO {

	public Person savePersonById(int eid, Person person) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if(encounter!=null)
		{
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			return person;
		}
		else
		{
			return null;
		}
		
	}

	public Person getPersonById(int pid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person  person= entityManager.find(Person.class, pid);
		if(person!=null)
		{
			return person;
		}
		else
		{
			return null;
		}
	}

	public boolean DeletePersonById(int pid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person  person= entityManager.find(Person.class, pid);
		if(person!=null)
		{
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}
	}

	public Person UpdatePersonById(int pid, Person person) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person  person1= entityManager.find(Person.class, pid);
		if(person1!=null)
		{
			person1.setAge(person.getAge());
			person1.setAdress(person.getAdress());
			person1.setPhn(person.getPhn());
			person1.setAge(person.getAge());
			person1.setGender(person.getGender());
			person1.setDateofbirth(person.getDateofbirth());	
			
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
			return person1;
		}
		else
		{
			return person;
		}
	}

	public List<Person> getAllPerson() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select p from Person p ");
		List<Person> person=query.getResultList();
		
		return null;
	}

	public List<Person> getPersonByGender(String gender) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select p from Person p where p.gender=?1 ");
		query.setParameter(1, gender);
		
		List<Person> person=query.getResultList();
		
		return person;
	}

	public List<Person> getAllPersonByAge(int age) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select p from Person p where p.age=?1 ");
		query.setParameter(1, age);
		
		List<Person> person=query.getResultList();
		
		return person;
	}

	public List<Person> getAllPersonByPhone(long phn) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Query query=entityManager.createQuery("select p from Person p where p.phone=?1 ");
		query.setParameter(1, phn);
		
		List<Person> person=query.getResultList();
		
		return person;
	}

}
