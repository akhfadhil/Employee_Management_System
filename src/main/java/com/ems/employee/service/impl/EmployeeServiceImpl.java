package com.ems.employee.service.impl;

import java.util.List;
import java.util.Optional;

import com.ems.employee.dao.EmployeeDao;
import com.ems.employee.exception.ResourceNotFoundException;
import com.ems.employee.model.Employee;
import com.ems.employee.repository.EmployeeRepository;
import com.ems.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    private EmployeeRepository employeeRepository;

    // @Override
    // public Employee saveEmployee(Employee employee) {
    // // TODO Auto-generated method stub
    // return employeeRepository.save(employee);
    // }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    // Save employee
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employee
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    // Get employee by id
    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
    }

    // Update employee
    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee employeeExist = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employeeExist.setFirstName(employee.getFirstName());
        employeeExist.setLastName(employee.getLastName());
        employeeExist.setEmail(employee.getEmail());
        employeeExist.setAddress(employee.getAddress());
        employeeExist.setPhone(employee.getPhone());
        employeeExist.setExpert(employee.getExpert());
        employeeExist.setSalary(employee.getSalary());
        employeeExist.setJoiningdate(employee.getJoiningdate());
        employeeExist.setRetireddate(employee.getRetireddate());

        employeeRepository.save(employeeExist);
        return employeeExist;
    }

    // Delete employee
    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employeeRepository.deleteById(id);

    }

}
