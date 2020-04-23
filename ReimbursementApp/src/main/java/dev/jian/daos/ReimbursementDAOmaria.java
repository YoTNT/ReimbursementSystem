package dev.jian.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.jian.entities.Reimbursement;
import dev.jian.utils.ConnectionUtil;

public class ReimbursementDAOmaria implements ReimbursementDAO{

	@Override
	public Reimbursement getReimbursementById(Reimbursement reimbursement) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "SELECT * FROM reimbursementsystem.REIMBURSEMENT WHERE REIMBURSEMENT_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursement.getrId());
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Reimbursement rm = new Reimbursement();
			rm.setrId(rs.getInt("REIMBURSEMENT_ID"));
			rm.setAmount(rs.getInt("AMOUNT"));
			rm.setDescription(rs.getString("DESCRIPTION"));
			rm.setDatetime(rs.getString("REIMBURSEMENT_DATETIME"));
			rm.setRequesterId(rs.getInt("REQUESTER_ID"));
			rm.setStatus(rs.getString("STATUS"));
			
			return rm;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Reimbursement> getReimbursementByRequesterId(int id) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "SELECT * FROM reimbursementsystem.REIMBURSEMENT WHERE REQUESTER_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				Reimbursement rm = new Reimbursement();
				rm.setrId(rs.getInt("REIMBURSEMENT_ID"));
				rm.setAmount(rs.getInt("AMOUNT"));
				rm.setDescription(rs.getString("DESCRIPTION"));
				rm.setDatetime(rs.getString("REIMBURSEMENT_DATETIME"));
				rm.setRequesterId(rs.getInt("REQUESTER_ID"));
				rm.setStatus(rs.getString("STATUS"));
				
				reimbursements.add(rm);
			}
			
			return reimbursements;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus(String status) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "SELECT * FROM reimbursementsystem.REIMBURSEMENT WHERE STATUS = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				Reimbursement rm = new Reimbursement();
				rm.setrId(rs.getInt("REIMBURSEMENT_ID"));
				rm.setAmount(rs.getInt("AMOUNT"));
				rm.setDescription(rs.getString("DESCRIPTION"));
				rm.setDatetime(rs.getString("REIMBURSEMENT_DATETIME"));
				rm.setRequesterId(rs.getInt("REQUESTER_ID"));
				rm.setStatus(rs.getString("STATUS"));
				
				reimbursements.add(rm);
			}
			
			return reimbursements;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "SELECT * FROM reimbursementsystem.REIMBURSEMENT";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				Reimbursement rm = new Reimbursement();
				rm.setrId(rs.getInt("REIMBURSEMENT_ID"));
				rm.setAmount(rs.getInt("AMOUNT"));
				rm.setDescription(rs.getString("DESCRIPTION"));
				rm.setDatetime(rs.getString("REIMBURSEMENT_DATETIME"));
				rm.setRequesterId(rs.getInt("REQUESTER_ID"));
				rm.setStatus(rs.getString("STATUS"));
				
				reimbursements.add(rm);
			}
			
			return reimbursements;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "INSERT INTO reimbursementsystem.REIMBURSEMENT VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setInt(2, reimbursement.getAmount());
			ps.setString(3, reimbursement.getDescription());
			ps.setString(4, reimbursement.getDatetime());
			ps.setInt(5, reimbursement.getRequesterId());
			ps.setString(6, reimbursement.getStatus());
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			
			int key = rs.getInt("REIMBURSEMENT_ID");
			reimbursement.setrId(key);
			
			return reimbursement;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "UPDATE reimbursementsystem.REIMBURSEMENT SET STATUS = ? WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, reimbursement.getStatus());
			ps.setInt(2, reimbursement.getrId());
			
			ps.execute();
			
			return reimbursement;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
