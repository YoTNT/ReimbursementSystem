package dev.jian.daotests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dev.jian.daos.SchoolDAO;
import dev.jian.daos.SchoolDAOLocal;
import dev.jian.entities.School;

public class SchoolDAOTests {

	static SchoolDAO sdao = new SchoolDAOLocal();
	
	// All tests pass unless an exception or error is throw
	// JUNIT does not care about your ordering
	// it will in a predetermined order outside of your control
	
	@Before
	public void setup() {
		School school = new School();
		school.setName("Coral Glades");
		school.setPhone(55555555);
		school.setCapacity(2000);
		school = sdao.createSchool(school);
		
		
		School school2 = new School();
		school2.setName("Stoneman Douglass");
		school2.setPhone(999999);
		school2.setCapacity(3000);
		school2 = sdao.createSchool(school2);
	}
	
	@Test
	public void createSchoolTest() {
		School school = new School();
		school.setName("Coral Glades");
		school.setPhone(55555555);
		school.setCapacity(2000);
		
		school = sdao.createSchool(school);
		
		System.out.println(school);
		
		School school2 = new School();
		school2.setName("Stoneman Douglass");
		school2.setPhone(999999);
		school2.setCapacity(3000);
		
		System.out.println(school2);
		
	}
	
	@Test
	public void getAllSchoolsTest() {
		System.out.println(sdao.getAllSchools());
	}
	
	@Test
	public void getAllSchoolByNameTest() {
		System.out.println(sdao.getSchoolByName("Coral Glades"));
	}

}
