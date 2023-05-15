package com.clientaccess;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dao.EmployeeDao;
import com.daoimpl.EmployeeDAOImpl;
import com.model.Employee;

public class Access 
{
	public static void main(String[] args) 
	{
		EmployeeDao employeeDAO = new EmployeeDAOImpl();
		Employee employee=getEmployee();
		employeeDAO.createEmployee(employee);
		getEmployeeById(employeeDAO);
		employeeDAO.updateEmployeeEmailById("abinaya@gmail.com", 1);
		employeeDAO.deleteEmployeeById(2);
		getAllEmployeesInfo(employeeDAO);
		employeeDAO.getAllEmployeesInfo();
	}
	private static void getAllEmployeesInfo(EmployeeDao employeeDAO)
	{
			List<Employee> empList=employeeDAO.getAllEmployeesInfo();
			for(Employee employee2:empList)
			{
				System.out.println(employee2);
			}
	}
	private static void getEmployeeById(EmployeeDao employeeDAO)
	{
		Employee employee3=employeeDAO.getEmployeeById(2);
		if(employee3!=null)
		{
			System.out.println(employee3);
		}
		else
		{
			System.out.println("employee does not exist...");
		}	
	}
	private static Employee getEmployee()
	{
		Employee employee=new Employee();
		employee.setEmployeeid(2);
		employee.setBonus(new BigDecimal(2222));
		employee.setDate_of_joining(new Date());
		employee.setEmployeename("nan");
		employee.setEmail("abi@gmail.com");
		employee.setSalary(44567.9);
		return employee;
	}
}
