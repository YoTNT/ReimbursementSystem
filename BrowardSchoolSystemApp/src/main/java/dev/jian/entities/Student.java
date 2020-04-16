package dev.jian.entities;

public class Student {

	// unique to every instance of student
	// unique way to identify a student
	// Primary key
	private int studentId;
	
	private String name;
	
	// A way to identify what schoold this student is part of
	// Foreign key
	private int schoolId;

	public int getId() {
		return studentId;
	}

	public void setId(int id) {
		this.studentId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	@Override
	public String toString() {
		return "Student [id=" + studentId + ", name=" + name + ", schoolId=" + schoolId + "]";
	}
	
	
}
