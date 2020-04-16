package dev.jian.servicetests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.jian.entities.School;
import dev.jian.services.SchoolService;
import dev.jian.services.SchoolServiceImpl;

public class SchoolServicetests {

	private static SchoolService schoolserv = new SchoolServiceImpl();
	
	@Test
	public void test() {
		
		School school = new School();
		school.setName("Coral Springs High");
		school.setPhone(777777);
		school.setCapacity(1000);
		
		schoolserv.establishSchool(school);
		
		System.out.println(school);
	}

}
