package dao;

import pojos.Course;

public interface CourseInterface {
	// launch a course
	String launchNewCourse(Course newCourse) ;
	// cancel the course 
	String cancelTheCourse(int courseId);
	// get course details
	Course getCourseDetails(String courseName);
	// getting student-course details with 2 separate joins 
	Course getCourseStudentDetails(String courseName);
	// get courseDetails as per join 1 query
	Course getCourseStudentDetailsWithJoin(String courseName);
}
