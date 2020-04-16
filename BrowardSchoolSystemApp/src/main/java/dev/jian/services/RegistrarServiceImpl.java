package dev.jian.services;

import dev.jian.daos.SchoolDAO;
import dev.jian.daos.SchoolDAOLocal;
import dev.jian.daos.SchoolDAOmaria;
import dev.jian.daos.StudentDAO;
import dev.jian.daos.StudentDAOLocal;
import dev.jian.daos.StudentDAOmaria;
import dev.jian.entities.School;
import dev.jian.entities.Student;

public class RegistrarServiceImpl implements RegistrarService{
	
	private SchoolDAO schooldao = new SchoolDAOmaria();
	private StudentDAO studentdao = new StudentDAOmaria();

	public Student enrollStudent(Student student) {
		this.studentdao.createStudent(student);
		return student;
	}

	public Student enrollStudent(Student student, School school) {
		student.setSchoolId(school.getSchoolId());
		this.studentdao.createStudent(student);
		
		school.getStudents().add(student);
		
		return student;
	}

	public Student expelStudent(Student student) {
		this.studentdao.deleteStudent(student);
		
		School school = schooldao.getSchoolById(student.getSchoolId());
		school.getStudents().remove(student);
		
		student.setId(-1);
		return student;
	}

	public Student transferStudent(Student student, School school) {
		School oldschool = schooldao.getSchoolById(student.getSchoolId());
		
		student.setSchoolId(school.getSchoolId());
		this.studentdao.updateStudent(student);
		school.getStudents().add(student);
		return student;
	}

}
