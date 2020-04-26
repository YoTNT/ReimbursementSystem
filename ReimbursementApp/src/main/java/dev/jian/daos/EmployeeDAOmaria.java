package dev.jian.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.jian.entities.Employee;
import dev.jian.utils.ConnectionUtil;

public class EmployeeDAOmaria implements EmployeeDAO{

	public Employee getEmployeeById(Employee employee) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "SELECT * FROM reimbursementsystem.EMPLOYEE WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.geteId());
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			Employee emp = new Employee();
			emp.seteId(rs.getInt("EMPLOYEE_ID"));
			emp.setName(rs.getString("EMPLOYEE_NAME"));
			emp.setUsername(rs.getString("USER_NAME"));
			emp.setPassword(rs.getString("USER_PASSWORD"));
			
			return emp;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Employee> getAllEmployee() {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "SELECT * FROM reimbursementsystem.EMPLOYEE";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Employee> employees = new ArrayList<Employee>();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.seteId(rs.getInt("EMPLOYEE_ID"));
				emp.setName(rs.getString("EMPLOYEE_NAME"));
				emp.setUsername(rs.getString("USER_NAME"));
				emp.setPassword(rs.getString("USER_PASSWORD"));
				
				employees.add(emp);
			}
			
			return employees;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Employee getEmployeeByName(String name) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "SELECT * FROM reimbursementsystem.EMPLOYEE WHERE EMPLOYEE_NAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			Employee emp = new Employee();
			emp.seteId(rs.getInt("EMPLOYEE_ID"));
			emp.setName(rs.getString("EMPLOYEE_NAME"));
			emp.setUsername(rs.getString("USER_NAME"));
			emp.setPassword(rs.getString("USER_PASSWORD"));
			
			return emp;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
