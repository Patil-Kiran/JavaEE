package dao;

import pojos.Student;

public interface StudentInterface {
	// admit student 
	String addNewStudent(String courseName,Student student);
	String cancelAdmission(String courseName,int studentId);
}
