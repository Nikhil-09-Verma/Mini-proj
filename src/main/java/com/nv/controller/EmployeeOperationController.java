package com.nv.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	

	@GetMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp,@RequestParam("no") int no) 
	{
		//use service
		
		Employee e1= empService.getEmpById(no);
		//copy e1 obj data to Model Class object
		
		BeanUtils.copyProperties(e1, emp);
		
		return "emp_edit";
		
	}
	
	@PostMapping("/edit")
	public String UpdateEployee(@ModelAttribute("emp") Employee emp,RedirectAttributes atts)
	{
		String msg= empService.updateEmployee(emp);
		atts.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no, RedirectAttributes atts) 
	{
		//use service
		
		String msg= empService.deleteEmployee(no);
		//put tha msg into flash Attrinute show we can pass and flash msg in browser
		atts.addFlashAttribute("resultMsg",msg);
		
		return "redirect:report";
		
	}
}
