package tester;

import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.*;
import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Course;
import static utils.HibernateUtils.*;

public class CancelStudentAdmission {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory factory = getFactory()){
			
			StudentDaoImpl studentDao = new StudentDaoImpl();
			System.out.println("Hibernate running......"+ factory);
			System.out.println("Enter new course name n student id ");
			String courseName = sc.next();
			int studentId = sc.nextInt();
			System.out.println(studentDao.cancelAdmission(courseName, studentId));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
