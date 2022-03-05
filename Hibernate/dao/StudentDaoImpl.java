package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements StudentInterface {

	@Override
	public String addNewStudent(String courseTitle,Student student) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String mesg = "Student Adding Failed";
		// ADD 
		String jpql = "select c from Course c where c.title=: title";
		try {
			Course c = session.createQuery(jpql, Course.class).setParameter("title", courseTitle).getSingleResult();
			// estb bidirection link between student and  course
			c.addStudent(student );
			// cascade = cascadeType.ALL takes care of all
			//session.persist(student);
			tx.commit();
			mesg = "Student Addmission done !!" +student.getName() +" Student id:"+student.getChoseCourse().getTitle();
		}catch(RuntimeException e) {
			if(tx !=null) {
				tx.commit();
			}
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelAdmission(String courseName, int studentId) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String mesg = "Student Removal Failed";
		String jpql = "select c from Course c where c.title= :title";
 		try {
			// estb bidirection link between student and  course
			// get couorse from its name
			Course c = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();
			 Student s = session.get(Student.class, studentId);
			 if( s != null) {
				 // remove bi-direction link
				 c.removeStudent(s);
				 mesg = "student "+s.getName()+" admission cancelled";
			 }
			// cascade = cascadeType.ALL takes care of all
			//session.persist(student);
			tx.commit();
		}catch(RuntimeException e) {
			if(tx !=null) {
				tx.commit();
			}
			throw e;
		}
		return mesg    ;
	}

}
