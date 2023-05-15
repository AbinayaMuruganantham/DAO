package com.model;

import java.math.BigDecimal;
import java.util.Date;

public class Employee
{
	int employeeid;
	String employeename;
	String email;
	double salary;
	Date date_of_joining;
	BigDecimal bonus;
	
	public int getEmployeeid() {
		return employeeid;
	}

	
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", email=" + email
				+ ", salary=" + salary + ", dateofjoining=" + date_of_joining + ", bonus=" + bonus + "]";
	}
	
	
	

}
