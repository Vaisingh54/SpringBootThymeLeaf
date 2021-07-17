package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.bean.Employee;
import com.example.demo.service.IEmployeeService;


@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	IEmployeeService ser;
	
	
	@GetMapping("/menu")
	public String getAllEmployee(Model model)
	{
		model.addAttribute("empList", ser.getAllEmployee());
		
		return "ShowAll";
		
	}
	
	@GetMapping("/showAddEmployeeForm")
	public String showAddForm(Model model)
	{
		Employee emp=new Employee();
		model.addAttribute("emp", emp);
		return "AddForm";
	}
	
	@PostMapping("/addEmp")
	public String addEmployee(@ModelAttribute Employee emp)
	{
		ser.addEmployee(emp);
		return "redirect:/menu";
	}
	
	@GetMapping("/showUpdateEmployeeForm/{empId}")
	public String showUpdateForm(@PathVariable(value = "empId") int empId,  Model model)
	{
		
		Employee emp=ser.getEmployee(empId);
		model.addAttribute("emp", emp);
		return "UpdateForm";
	
	}
	
	@GetMapping("/showDeleteEmployeeForm/{empId}")
	public String showDeleteForm(@PathVariable(value = "empId") int empId)
	{
		ser.deleteEmployee(empId);
		return "redirect:/menu";
	}
	
}
