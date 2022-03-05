package pojos;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="projects")
public class Project extends BaseEntity {
	@Column(length=100,unique=true)
	private String title;
	@Column(length=100)
	private String technology;
	@Column(name="completion_date")
	private LocalDate completionDate;
	// Many to Many 
	// uni dir association Project*--->*Student (between 2 entries)
	@ManyToMany // Mandatory otherwise MappingException
	// Join table and column names by default giben by hibernate to customization
	@JoinTable(name="project_students",joinColumns =@JoinColumn(name="project_id"),inverseJoinColumns = @JoinColumn(name="student_id")) // Optional 
	private Set<Student> students = new HashSet<>();
	
	
	public Project() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}
	// 2 method 
	public void addStudent(Student s) {
		//supported by hashSet
		students.add(s);	
	}
	
	public void removeStudent(Student s) {
		// HAshSet  Method 
		students.remove(s);
	}
	
	@Override
	public String toString() {
		return "Project [id ="+getId()+" title=" + title + ", technology=" + technology + ", completionDate=" + completionDate + "]";
	}
	
	
	
}
