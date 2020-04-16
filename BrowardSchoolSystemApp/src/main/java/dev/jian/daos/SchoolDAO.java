package dev.jian.daos;

import java.util.List;

import dev.jian.entities.School;

public interface SchoolDAO {

	// DAOs should have all crud functionality
	// CREATE
	// READ
	// UPDATE
	// DELETE
	
	// Use objects whenever you can
	// Return objects when you can
	School createSchool(School school);
		
	School getSchoolById(int id);
	School getSchoolByName(String name);
	List<School> getAllSchools();
	
	School updateSchool(School school);
	
	boolean deleteSchool(School school);
	
}
