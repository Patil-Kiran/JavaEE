package tester;

import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.*;

import dao.AddressDaoImpl;
import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import dao.StudentInterface;
import pojos.Address;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.*;

public class TestAddStudentsAddress {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory factory = getFactory()){
			AddressDaoImpl addressDao = new AddressDaoImpl();
			System.out.println("Hibernate running......"+ factory);
			System.out.println("Enter Student Address details : StudentId,City,State,Country,ZipCode");
			System.out.println(addressDao.assignAddressDetails(sc.nextInt(), new Address(sc.next(), sc.next(), sc.next(), sc.next())));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
