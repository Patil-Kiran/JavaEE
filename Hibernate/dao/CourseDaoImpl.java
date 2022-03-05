package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;

public class CourseDaoImpl implements CourseInterface {

	@Override
	public String launchNewCourse(Course newCourse) {
		String mesg = "Adding a Course Failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx  = session.beginTransaction();
		try {
			session.persist(newCourse);
			tx.commit();
			mesg = "Course Launched Successfully, CourseId ="+newCourse.getId();
		} catch (RuntimeException e) {
			if(tx !=null) {
				tx.rollback();
			}
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelTheCourse(int courseId) {
		String mesg = "Deleting a Course Failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx  = session.beginTransaction();
		try {
			Course c = session.get(Course.class, courseId);
			// possibility that get method return null;
			if(c !=null) {
				session.delete(c); // REMOVED : CHILD FIRST THEN PARENT 
				mesg = "Course Deleted Successfully, CourseId ="+courseId;
			}
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx !=null) {
				tx.rollback();
			}
			throw e;
		}
		return mesg;
	}

	@Override
	public Course getCourseDetails(String courseName) {
		Course c=  null;
		String mesg = " Course Not Found";
		String jpql = "select c from Course c where c.title = :title";
		Session session = getFactory().getCurrentSession();
		Transaction tx  = session.beginTransaction();
		try {
			 c = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult(); 
			// possibility that get method return null;
			// if(c !=null) {
				//session.delete(c); // REMOVED : CHILD FIRST THEN PARENT 
				mesg = "Course Found Successfully, Course Details ="+c.toString();
			//}
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx !=null) {
				tx.rollback();
			}
			throw e;
		}
		return c;
	}

	@Override
	public Course getCourseStudentDetails(String courseName) {
		Course c=  null;
		String mesg = " Course Not Found";
		String jpql = "select c from Course c where c.title = :title";
		Session session = getFactory().getCurrentSession();
		Transaction tx  = session.beginTransaction();
		try {
			 c = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();
			 //select qury on students table 
			c.getStudents().size();
			mesg = "Course Found Successfully, Course Details ="+c.toString();
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx !=null) {
				tx.rollback();
			}
			throw e;
		}
		return c;
	}

	@Override
	public Course getCourseStudentDetailsWithJoin(String courseName) {
		Course c=  null;
		String jpql = "select c from Course c join fetch c.students where c.title = :title";
		// 1.inner join query to fetch data from courses n students
		Session session = getFactory().getCurrentSession();
		Transaction tx  = session.beginTransaction();
		try {
			 c = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();
			 //select qury on students table 
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx !=null) {
				tx.rollback();
			}
			throw e;
		}
		return c;
	}

}
