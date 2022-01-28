package com.ems.employee.dao;

import javax.transaction.Transactional;

import com.ems.employee.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Employee employee) {
		String sql = "INSERT INTO employees ( address, email, first_name, expert, last_name, phone, salary , joiningdate, retireddate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, employee.getAddress(), employee.getEmail(), employee.getFirstName(),
				employee.getExpert(), employee.getLastName(), employee.getPhone(), employee.getSalary(),
				employee.getJoiningdate(), employee.getRetireddate());
	}
}
