package dao;

import org.hibernate.*;

import pojos.Project;
import static utils.HibernateUtils.*;

public class ProjectDaoImplementation implements ProjectInterface {

	@Override
	public String launchNewProject(Project project) {
		String mesg = "Project Adding Failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(project);
			tx.commit();
			mesg = "Project Added SuccessFully projectId ="+project.getId();
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return mesg;
	}

	@Override
	public String addStudentToProject(int projectId, int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeStudentFromProject(int projectId, int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
