package com.mk.hospital.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String dateofjoin;
	private String discharge;
	@OneToMany(mappedBy = "encounter",cascade =CascadeType.ALL )
	private List<Observation>observation;
	@JoinColumn
	@ManyToOne
	private Person person;
	@JoinColumn
	@ManyToOne
	private Branch branch;
	@OneToMany (mappedBy = "encounter")
	private List<MedicalOrder>medicalorder;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(String dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	public String getDischarge() {
		return discharge;
	}
	public void setDischarge(String discharge) {
		this.discharge = discharge;
	}
	public List<Observation> getObservation() {
		return observation;
	}
	public void setObservation(List<Observation> observation) {
		this.observation = observation;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public List<MedicalOrder> getMedicalorder() {
		return medicalorder;
	}
	public void setMedicalorder(List<MedicalOrder> medicalorder) {
		this.medicalorder = medicalorder;
	}
	
	

}
