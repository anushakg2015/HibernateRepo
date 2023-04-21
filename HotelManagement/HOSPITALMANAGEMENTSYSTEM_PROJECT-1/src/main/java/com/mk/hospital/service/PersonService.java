package com.mk.hospital.service;

import java.util.List;

import com.mk.hospital.DAOimp.PersonDAOIMP;
import com.mk.hospital.dto.Person;


public class PersonService 
{
	public void savePerson(int eid,Person person)
	{
		PersonDAOIMP perDaoimp=new PersonDAOIMP();
		Person person1=perDaoimp.savePersonById(eid, person);
		if(person1!=null)
		{
			System.out.println("Persons Saved");
		}
		else
		{
			System.out.println("Unfortunately data not found");
		}
	}
	
	public Person getPersonById(int pid)
	{
		PersonDAOIMP perDaoimp=new PersonDAOIMP();
		Person person=perDaoimp.getPersonById(pid);
		if(person!=null)
		{
			return person;
		}
		else
		{
			return null;
		}
	}
	public void deletePersonById(int pid)
	{
		PersonDAOIMP perDaoimp=new PersonDAOIMP();
		boolean flag=perDaoimp.DeletePersonById(pid);
		if(flag)
		{
			System.out.println("Persons Deleted");
		}
		else
		{
			System.out.println("Person Not Deleted");
		}
	}
	
	public Person updatePersonById(int pid,Person person)
	{
		PersonDAOIMP perDaoimp=new PersonDAOIMP();
		Person person1=perDaoimp.UpdatePersonById(pid, person);
		if(person1!=null)
		{
			return person1;
		}
		else
		{
			return null;
		}
	}
	public List<Person> getAllPerson()
	{
		PersonDAOIMP daoImpl=new PersonDAOIMP();
		List<Person> person=daoImpl.getAllPerson();
		return person;
	}
	public List<Person> getPersonByGender(String gender)
	{
		PersonDAOIMP daoImpl=new PersonDAOIMP();
		List<Person> person=daoImpl.getPersonByGender(gender);
		return person;
	}
	public List<Person> getAllPersonByAge(int age)
	{
		PersonDAOIMP daoImpl=new PersonDAOIMP();
		List<Person> person=daoImpl.getAllPersonByAge(age);
		if(person.size()>0) {
			return person;
		}
		else
		{
			return null;
		}
	}
	public List<Person> getAllPersonByPhone(long phone)
	{
		PersonDAOIMP daoImpl=new PersonDAOIMP();
		List<Person> person=daoImpl.getAllPersonByPhone(phone);
		return person;
	}
}