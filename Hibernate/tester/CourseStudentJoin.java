package tester;

import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.*;
import dao.CourseDaoImpl;
import pojos.Course;
import static utils.HibernateUtils.*;

public class CourseStudentJoin {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory factory = getFactory()){
			
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Hibernate running......"+ factory);
			System.out.println("Enter new course details : title");
			String courseName = sc.next();
			Course course = courseDao.getCourseStudentDetails(courseName);
			System.out.println(course);
			// getting student associated with course
			System.out.println("Student details");
			course.getStudents().forEach(System.out::  println);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
