package tester;

import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.*;
import dao.CourseDaoImpl;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.*;

public class LaunchNewCourseWithStudents {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory factory = getFactory()){
			
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Hibernate running......"+ factory);
			System.out.println("Enter new course details : title,startDate,endDate,fees,capacity");
			Course newCourse = new Course(sc.next(), LocalDate.parse(sc.next()), LocalDate.parse(sc.next()), sc.nextDouble(), sc.nextInt());
			for(int i=0; i<10;i++) {
				System.out.println("Enter Students  Details : name , email");
				newCourse.addStudent(new Student(sc.next(), sc.next()));
			}
			System.out.println(courseDao.launchNewCourse(newCourse));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
