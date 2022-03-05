package tester;

import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.*;
import dao.CourseDaoImpl;
import pojos.Course;
import static utils.HibernateUtils.*;

public class DeleteCourse {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory factory = getFactory()){
			
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Hibernate running......"+ factory);
			System.out.println("Enter  Course Details to cance course : CourseId");
			System.out.println(courseDao.cancelTheCourse(sc.nextInt()));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
