package tester;

import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.*;
import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import dao.StudentInterface;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.*;

public class TestAddStudents {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory factory = getFactory()){
			StudentDaoImpl studentDao = new StudentDaoImpl();
			System.out.println("Enter course name");
			String courseName = sc.next();
			System.out.println("Hibernate running......"+ factory);
			System.out.println("Enter new Student details :name, email");
			System.out.println(studentDao.addNewStudent(courseName, new Student(sc.next(), sc.next())));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
