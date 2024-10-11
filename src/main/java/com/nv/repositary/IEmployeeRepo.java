package com.nv.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nv.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> 
{

}
