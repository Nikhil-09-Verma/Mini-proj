package com.nv.service;

import java.util.List;

import com.nv.model.Employee;

public interface IEmployeeService 
{
	List<Employee> showAllEmp();//for showing all emp details
	String registerEmployee(Employee emp);//for register emp
	Employee getEmpById(int id);
	String updateEmployee(Employee emp);
	String deleteEmployee(int no);
}
