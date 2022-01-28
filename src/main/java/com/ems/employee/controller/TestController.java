package com.ems.employee.controller;

import javax.validation.Valid;

import com.ems.employee.model.Employee;
import com.ems.employee.service.EmployeeService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Validated
public class TestController {

    private EmployeeService employeeService;

    public TestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public String save(@RequestBody Employee employee) {
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @PostMapping("/validate")
    public String getData(@RequestBody @Valid Employee employee) {
        System.out.println("Validate method data");
        return employee.getLastName();
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
