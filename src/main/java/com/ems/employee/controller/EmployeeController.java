package com.ems.employee.controller;

import com.ems.employee.model.Employee;
import com.ems.employee.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // Build create employee
    // @PostMapping("/employees")
    // public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
    //     return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    // }

    @PostMapping("/save")
	// public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    public String saveEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		
		return "redirect:/employees/list";
	}
    
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
