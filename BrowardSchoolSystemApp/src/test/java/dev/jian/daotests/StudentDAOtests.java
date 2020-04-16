package dev.jian.daotests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.jian.daos.StudentDAO;
import dev.jian.daos.StudentDAOLocal;
import dev.jian.entities.Student;

public class StudentDAOtests {

	private static StudentDAO studao = new StudentDAOLocal();
	
	@Before
	public void setup() {
		Student student = new Student();
		student.setName("Adam");
		Student student2 = new Student();
		student2.setName("Mark");
		
		studao.createStudent(student);
		studao.createStudent(student2);
	}
	
	@Test
	public void test() {
		
		Student student = new Student();
		student.setName("Adam");
		Student student2 = new Student();
		student2.setName("Mark");
		
		studao.createStudent(student);
		studao.createStudent(student2);
		
		System.out.println(student);
		System.out.println(student2);
	}

	
	@Test
	public void getAllStudents() {
		List<Student> students = studao.getAllStudent();
		System.out.println(students);
	}
	
	@Test
	public void getAllStudentsBySchoolId() {
		
		List<Student> students = studao.getAllStudentBySchoolId(3);
		System.out.println(students);
	}
}
