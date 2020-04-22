package dev.jian.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.jian.entities.Manager;
import dev.jian.utils.ConnectionUtil;

public class ManagerDAOmaria implements ManagerDAO{

	@Override
	public Manager getManagerById(Manager manager) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "SELECT * FROM reimbursementsystem.MANAGER WHERE MANAGER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, manager.getmId());
			
			ResultSet rs = ps.executeQuery();
			rs.next();

			Manager mg = new Manager();
			mg.setmId(rs.getInt("MANAGER_ID"));
			mg.setName(rs.getString("MANAGER_NAME"));
			mg.setUsername(rs.getString("USER_NAME"));
			mg.setPassword(rs.getString("USER_PASSWORD"));
			
			return mg;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Manager> getAllManager() {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "SELECT * FROM reimbursementsystem.MANAGER";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Manager> managers = new ArrayList<Manager>();
			
			while(rs.next()) {
				Manager mg = new Manager();
				mg.setmId(rs.getInt("MANAGER_ID"));
				mg.setName(rs.getString("MANAGER_NAME"));
				mg.setUsername(rs.getString("USER_NAME"));
				mg.setPassword(rs.getString("USER_PASSWORD"));
				
				managers.add(mg);
			}
			
			return managers;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Manager getManagerByName(String name) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "SELECT * FROM reimbursementsystem.MANAGER WHERE MANAGER_NAME = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			Manager mg = new Manager();
			mg.setmId(rs.getInt("MANAGER_ID"));
			mg.setName(rs.getString("MANAGER_NAME"));
			mg.setUsername(rs.getString("USER_NAME"));
			mg.setPassword(rs.getString("USER_PASSWORD"));
			
			return mg;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
