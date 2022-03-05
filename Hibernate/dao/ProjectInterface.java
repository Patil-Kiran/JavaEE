package dao;

import pojos.Project;
import pojos.Student;

public interface ProjectInterface {
	// launch new project
	String launchNewProject(Project project);
	// add student to project
	String addStudentToProject(int projectId,int studentId);
	// 2Persistent entries in L1 cache 
	// remove student from projectId
	String removeStudentFromProject(int projectId,int studentId);
}
