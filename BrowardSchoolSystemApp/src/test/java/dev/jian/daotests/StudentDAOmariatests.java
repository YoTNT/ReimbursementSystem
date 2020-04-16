package dev.jian.daotests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dev.jian.daos.StudentDAO;
import dev.jian.daos.StudentDAOmaria;
import dev.jian.entities.Student;

public class StudentDAOmariatests {

	public static StudentDAO studentdao = new StudentDAOmaria();
	
	@Test
	public void createStudent() {
		Student adam = new Student();
		adam.setName("Mark");
		adam.setSchoolId(2);
		studentdao.createStudent(adam);
		
		System.out.println(adam);
	}
	
	@Test
	public void getAllStudents() {
		List<Student> students = studentdao.getAllStudent();
		System.out.println(students);
	}
	


}
