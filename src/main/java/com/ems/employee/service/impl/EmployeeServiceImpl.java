package com.ems.employee.service.impl;

import com.ems.employee.dao.EmployeeDao;
import com.ems.employee.model.Employee;
import com.ems.employee.repository.EmployeeRepository;
import com.ems.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
	private EmployeeDao employeeDao;
    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeRepository.save(employee);
    }

    @Override
    public void save(Employee employee) {
        // TODO Auto-generated method stub
        employeeDao.save(employee);
    }
    
}
