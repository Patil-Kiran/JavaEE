package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.*;

public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(SessionFactory factory = getFactory()){
			System.out.println("hibernaterunning  up n....."+factory);
		}
	}

}
