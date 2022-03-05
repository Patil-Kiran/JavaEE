package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Student;

public class AddressDaoImpl implements AddressInterface {

	@Override
	public String assignAddressDetails(int studentId, Address address) {
		String mesg = "Address Linking Failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Student student = session.get(Student.class,studentId);
			if(student !=null) {
				// Student not linked with Address
				// Linking done via setters and getters
				address.setStudent(student); // uni dir relation between address---> Student
				session.persist(address);
				mesg = "Address Linked with student "+student.getId();
			}
			tx.commit();
		}catch(RuntimeException e) {
			if( tx !=null){
				tx.rollback();
			}
			throw e;
		}
		return mesg;
	}

}
