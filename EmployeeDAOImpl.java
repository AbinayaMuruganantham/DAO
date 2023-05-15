package com.daoimpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//+-import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.dao.EmployeeDao;
import com.model.Employee;
import com.util.DBUtil;

public class EmployeeDAOImpl implements EmployeeDao
{
	public void createEmployee(Employee employee)


	{
		String SQL="INSERT INTO employee(employeeid,employeename,email,salary,date_of_joining,bonus) values(?,?,?,?,?,?);";
		try{
			Connection connection=DBUtil.getConnection();
		
				PreparedStatement ps=connection.prepareStatement(SQL);
				ps.setInt(1, employee.getEmployeeid());
			ps.setString(2,employee.getEmployeename());
			ps.setString(3,employee.getEmail());
			ps.setDouble(4, employee.getSalary());
			ps.setDate(5,new Date(employee.getDate_of_joining().getTime()));
			ps.setBigDecimal(6, employee.getBonus());
			
			int executeUpdate =ps.executeUpdate();
			
			if(executeUpdate==1)
			{
				System.out.println("employee is created...");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}

	public Employee getEmployeeById(Integer employee)




	{
		// TODO Auto-generated method stub
		Employee emp =null;
		String sql="SELECT * FROM employee WHERE employeeid=?;";
		try
		{
			Connection connection =DBUtil.getConnection();
				PreparedStatement ps=connection.prepareStatement(sql);
				ps.setInt(1, employee);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					int empId=rs.getInt("employeeid");
					String employeename=rs.getString("employeename");
					String email=rs.getString("email");
					Double salary = rs.getDouble("salary");
					BigDecimal bonus=rs.getBigDecimal("bonus");
					Date date=rs.getDate("date_of_joining");
					
					emp =new Employee();
					emp.setEmployeename(employeename);
					emp.setBonus(bonus);
					emp.setEmployeeid(empId);
					emp.setDate_of_joining(date);
					emp.setSalary(salary);
					emp.setEmail(email);
					
				}
		}
		catch(Exception e)
		{
            e.printStackTrace();			
		}
		return emp;
	}

	public void updateEmployeeEmailById(String newEmail, Integer employeeid)
	{
		// TODO Auto-generated method stub
		String SQL="UPDATE employee set email=? WHERE employeeid=?;";
		try
		{
			Connection connection=DBUtil.getConnection();
			PreparedStatement ps=connection.prepareStatement(SQL);
			ps.setString(1, newEmail);
			ps.setInt(2, employeeid);
			int executeUpdate=ps.executeUpdate();
			if(executeUpdate==1)
			{
				System.out.println("employee email is updated...");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		
	}

	
	public void deleteEmployeeById(Integer employeeid)

	{
		// TODO Auto-generated method stub
		String SQL="DELETE FROM employee WHERE employeeid=?;";
		try
		{
			Connection connection=DBUtil.getConnection();
			PreparedStatement ps=connection.prepareStatement(SQL);
			
			ps.setInt(1, employeeid);
			int executeUpdate=ps.executeUpdate();
			if(executeUpdate==1)
			{
				System.out.println("employee deleted with id.."+employeeid);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		
	}

	public List<Employee> getAllEmployeesInfo()
 
	{
		// TODO Auto-generated method stub
		List<Employee> empList=new ArrayList<Employee>();
		String sql="SELECT * FROM employee;";
		try
		{
			Connection connection =DBUtil.getConnection();
				PreparedStatement ps=connection.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					int empId=rs.getInt("employeeid");
					String employeename=rs.getString("employeename");
					String email=rs.getString("email");
					Double salary = rs.getDouble("salary");
					BigDecimal bonus=rs.getBigDecimal("bonus");
					Date date=rs.getDate("date_of_joining");
					
					Employee emp1 =new Employee();
					emp1.setEmployeename(employeename);
					emp1.setBonus(bonus);
					emp1.setEmployeeid(empId);
					emp1.setDate_of_joining(date);
					emp1.setSalary(salary);
					emp1.setEmail(email);
					empList.add(emp1);	
				}
		}
		catch(Exception e)
		{
            e.printStackTrace();			
		}
		return empList;
	}
}
