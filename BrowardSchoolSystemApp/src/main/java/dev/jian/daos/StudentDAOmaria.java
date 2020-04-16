package dev.jian.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.jian.entities.Student;
import dev.jian.utils.ConnectionUtil;

public class StudentDAOmaria implements StudentDAO{

	@Override
	public Student createStudent(Student student) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "INSERT INTO browardschooldb.STUDENT VALUE (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setString(2, student.getName());
			ps.setInt(3, student.getSchoolId());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			// "list" of just generated keys
			rs.next();	// gets first record
			
			// Result set is a data type kinda like how you could store things in a list
			
			int key = rs.getInt("STUDENT_ID");
			student.setId(key);
			
			return student;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Student getStudentById(int id) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM STUDENT WHERE STUDENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Student student = new Student();
			
			student.setId(rs.getInt("STUDENT_ID"));
			student.setName(rs.getString("NAME"));
			student.setSchoolId(rs.getInt("SCHOOL_ID"));
			
			return student;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Student> getAllStudent() {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM STUDENT";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();


			List<Student> students = new ArrayList<Student>();
			
			while(rs.next()) {
				Student student = new Student();
				
				student.setId(rs.getInt("STUDENT_ID"));
				student.setName(rs.getString("NAME"));
				student.setSchoolId(rs.getInt("SCHOOL_ID"));
				
				students.add(student);
			}
			
			
			return students;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Student> getAllStudentBySchoolId(int id) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT * FROM STUDENT WHERE SCHOOL_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();


			List<Student> students = new ArrayList<Student>();
			
			while(rs.next()) {
				Student student = new Student();
				
				student.setId(rs.getInt("STUDENT_ID"));
				student.setName(rs.getString("NAME"));
				student.setSchoolId(rs.getInt("SCHOOL_ID"));
				
				students.add(student);
			}
			
			
			return students;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Student updateStudent(Student student) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "UPDATE browardschooldb.STUDENT SET NAME = ?, SCHOOL_ID = ? WHERE STUDENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setInt(2, student.getSchoolId());
			ps.setInt(3, student.getId());
			ps.execute();
			
			return student;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteStudent(Student student) {
		
		try(Connection conn = ConnectionUtil.createConnection()){
			
			String sql = "DELECT FROM STUDENT WHERE STUDENT_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, student.getId());
			boolean success = ps.execute();
			
			
			return success;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
