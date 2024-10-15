package com.nv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.model.Employee;
import com.nv.repositary.IEmployeeRepo;

@Service("emp_service")
public class EmployeeMgmtService implements IEmployeeService
{
	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public List<Employee> showAllEmp() 
	{
		
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) 
	{
		int idval= empRepo.save(emp).getEid();
		return idval+"employee register sucessfully";
	}

	@Override
	public Employee getEmpById(int id)
	{
		Employee emp= empRepo.getReferenceById(id);
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		
		Employee emp1= empRepo.save(emp);
		return emp1.getEid()+"Employee Updated successfully::";
	}

	@Override
	public String deleteEmployee(int no) 
	{
		empRepo.deleteById(no);
		return "Employee deleted Successfully::";
	}

}
