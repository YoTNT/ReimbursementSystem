package dev.jian.services;

import dev.jian.entities.School;

public interface SchoolService {
	
	School establishSchool(School school);
	boolean decomissionSchool(School school);

}
