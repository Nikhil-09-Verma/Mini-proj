package com.nv.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nv.model.Employee;
import com.nv.service.IEmployeeService;

import jakarta.annotation.PostConstruct;

@Controller
public class EmployeeOperationController 
{
	@Autowired
	IEmployeeService empService;
	
	@GetMapping("/")
	public String showHome() 
	{
		return "welcome";
	}
	
	@GetMapping("/report")
	public String showReport(Map<String,Object> map) 
	{
		//use Service
		List<Employee> lst=empService.showAllEmp();
		//keep tha result into model attribute
		map.put("empinfo", lst);
		return "report";
	}
	
	
	@GetMapping("/register")
	public String registerEmployeeForm(@ModelAttribute("emp") Employee emp)
	{
		return "emp_register";
		
	}
	@PostMapping("/register")//PRG->solve double posting problem+ flash attribute
	public String registerEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes atts) 
	{
		String msg= empService.registerEmployee(emp);
		atts.addFlashAttribute("resultMsg",msg);
		
		return "redirect:report";
		
	}
}
