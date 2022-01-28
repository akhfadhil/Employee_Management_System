package com.ems.employee.service;

import com.ems.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);

    Employee saveEmployee(Employee employee);

    List<Employee> getAll();

    Employee getEmployeeById(long id);

    Employee updateEmployee(Employee employee, long id);

    void deleteEmployeeById(long id);
}
