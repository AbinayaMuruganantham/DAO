package com.dao;

import java.util.List;
import com.model.Employee;
public interface EmployeeDao 
{
	public abstract void createEmployee(Employee employee);
	public abstract Employee getEmployeeById(Integer employee);
	public abstract void updateEmployeeEmailById(String newEmail,Integer employeeid);
	public abstract void deleteEmployeeById(Integer employeeid);
	public abstract List<Employee> getAllEmployeesInfo();
}
