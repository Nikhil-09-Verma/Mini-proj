package com.nv.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="emp_info")
public class Employee implements Serializable 
{

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "emp_id_seq",initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer eid;
	private String eName;
	private String job;
	private Double sal;
}
