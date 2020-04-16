package dev.jian.services;

import dev.jian.entities.School;
import dev.jian.entities.Student;

// service responsible for enrolling students
// expelling students
// transfer students
public interface RegistrarService {

	Student enrollStudent(Student student);
	Student enrollStudent(Student student, School school);
	
	Student expelStudent(Student studnet);
	
	Student transferStudent(Student student, School school);
}
