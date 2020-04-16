package dev.jian.services;

import java.util.List;

import dev.jian.daos.SchoolDAO;
import dev.jian.daos.SchoolDAOLocal;
import dev.jian.daos.SchoolDAOmaria;
import dev.jian.daos.StudentDAO;
import dev.jian.daos.StudentDAOmaria;
import dev.jian.entities.School;
import dev.jian.entities.Student;

public class SchoolServiceImpl implements SchoolService{
	
	private SchoolDAO schooldao = new SchoolDAOmaria();
	private StudentDAO studentdao = new StudentDAOmaria();
	private RegistrarService rs = new RegistrarServiceImpl();

	public School establishSchool(School school) {
		schooldao.createSchool(school);
		return school;
	}

	@Override
	public boolean decomissionSchool(School school) {
		
		List<Student> students = studentdao.getAllStudentBySchoolId(school.getSchoolId());
		
		for(Student s : students) {
			rs.transferStudent(s, schooldao.getSchoolByName("Coral Glades"));
			studentdao.deleteStudent(s);
		}
		
		schooldao.deleteSchool(school);
		
		return true;
	}
	
	
}
