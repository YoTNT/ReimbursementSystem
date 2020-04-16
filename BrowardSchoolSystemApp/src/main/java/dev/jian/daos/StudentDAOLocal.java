package dev.jian.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.jian.entities.Student;

public class StudentDAOLocal implements StudentDAO{
	
	private static Map<Integer, Student> student_table = new HashMap<Integer, Student>();
	private static int idGenerator = 201;

	public Student createStudent(Student student) {
		student.setId(idGenerator);
		idGenerator++;
		
		student_table.put(student.getId(), student);
			
		return null;
	}

	public Student getStudentById(int id) {
		return student_table.get(id);
	}

	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>(student_table.values());
		return students;
	}

	public List<Student> getAllStudentBySchoolId(int id) {
		
		List<Student> cohort = new ArrayList<Student>();
		
		for(Student s : getAllStudent()) {
			if(s.getId() == id)
				cohort.add(s);
		}
		
		return cohort;
	}

	public Student updateStudent(Student student) {
		
		student_table.put(student.getId(), student);
		return student;
	}

	public boolean deleteStudent(Student student) {
	
		student_table.remove(student.getId());
		return true;
	}

	
	
}
