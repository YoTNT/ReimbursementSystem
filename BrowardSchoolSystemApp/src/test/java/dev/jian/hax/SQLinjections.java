package dev.jian.hax;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import dev.jian.utils.ConnectionUtil;

public class SQLinjections {

	@Test
	public void sqlInjection() {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			String id = "3";
			String sql = "SELECT * FROM browardschooldb.STUDENT WHERE STUDENT_ID = " + id;
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			
			String name = rs.getString("NAME");
			System.out.println(name);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
