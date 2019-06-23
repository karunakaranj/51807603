package com.usecase.personalloan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankEmployee {

	public Long getEmployeId() {
		return employeId;
	}
	public void setEmployeId(Long employeId) {
		this.employeId = employeId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long employeId;
	private String eName;
    private String level;
}
