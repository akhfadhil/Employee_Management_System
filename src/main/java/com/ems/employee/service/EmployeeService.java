package com.ems.employee.service;

import com.ems.employee.model.Employee;

public interface EmployeeService {
    
    Employee saveEmployee(Employee employee);

    void save(Employee employee);

}
