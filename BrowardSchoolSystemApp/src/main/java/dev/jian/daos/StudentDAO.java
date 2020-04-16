package dev.jian.daos;

import java.util.List;

import dev.jian.entities.Student;

public interface StudentDAO {

	Student createStudent(Student student);
	
	Student getStudentById(int id);
	List<Student> getAllStudent();
	List<Student> getAllStudentBySchoolId(int id);	
	
	Student updateStudent(Student student);
	
	boolean deleteStudent(Student student);
	
	
}
