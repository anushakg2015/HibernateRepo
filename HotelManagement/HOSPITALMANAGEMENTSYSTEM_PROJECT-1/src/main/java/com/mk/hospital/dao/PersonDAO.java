package com.mk.hospital.dao;

import java.util.List;

import com.mk.hospital.dto.Person;

public interface PersonDAO {
	public Person savePersonById(int eid,Person person);
	public Person getPersonById(int pid);
	public boolean DeletePersonById(int pid);
	public Person UpdatePersonById(int pid,Person person);
	public List<Person> getAllPerson();
	public List<Person> getPersonByGender(String gender);
	public List<Person> getAllPersonByAge(int age);
	public List<Person> getAllPersonByPhone(long phn);
	
	

}
