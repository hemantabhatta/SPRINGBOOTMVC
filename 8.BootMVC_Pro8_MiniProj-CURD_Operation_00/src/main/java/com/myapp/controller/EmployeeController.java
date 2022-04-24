package com.myapp.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.model.Employee;
import com.myapp.service.IEmpMgmtService;

@Controller
public class EmployeeController {
    @Autowired
    private IEmpMgmtService service;
    
    @GetMapping("/")
    public String showHomePage() {
	
	return "home";
    }
    @GetMapping("/emp_report")
    public String showEmployeeReport(Map<String,Object> map) {
	//use Service
	Iterable<Employee> empsList=service.getAllEmployees();
	map.put("empsList", empsList);
	System.out.println(empsList);
	return "employee_report";
    }
    @GetMapping("/insert_employee")
    public String showAddEmployee(@ModelAttribute("emp") Employee emp) {
	System.out.println("show Employee");
	return "add_employee";
    }
    @PostMapping("/insert_employee")
    public String insertEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map,HttpSession ses) {
	System.out.println(emp.getEmpno());
	
	String result=service.insertEmployee(emp);
	Iterable<Employee> empsList=service.getAllEmployees();
//	map.put("resultMsg", result);
	ses.setAttribute("resultMsg", result);
	map.put("empsList", empsList);
	return "redirect:emp_report";
    }
    @GetMapping("/edit_employee")
    public String showEditEmployee(@ModelAttribute("emp") Employee emp,@RequestParam("eno") int eno) {
	Employee emp1=service.getEmployeeByno(eno);
	BeanUtils.copyProperties(emp1, emp);
	return "Modify_emp";
    }
    @PostMapping("/edit_employee")
    public String editEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map) {
	
	String result=service.updateEmployee(emp);
//	Iterable<Employee> empsList=service.getAllEmployees();
//	map.put("empsList", empsList);
//	map.put("resultMsg", result);
	return "redirect:emp_report";
    }
    @GetMapping("/delete_employee")
    public String deleteEmployee(@RequestParam("eno") int eno,Map<String,Object> map) {
	String result=service.deleteEmployeeByEno(eno);
//	Iterable<Employee> empsList=service.getAllEmployees();
//	map.put("empsList", empsList);
//	map.put("resultMsg", result);
	return "redirect:emp_report";
    }

}
