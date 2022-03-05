package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student extends BaseEntity{
	@Column(length=30)
	private String name;
	@Column(length=30,unique=true)
	private String email;
	// uni directional from Student to*----> Courses
	@ManyToOne // nullable = not null
	@JoinColumn(name="course_id",nullable=false)
	private Course choseCourse;
	@Embedded // Completely Optional :Added only for understanding
	private AdharCard adharCard; 
	// uni-dir assoc bet entity and collection of basic values
	@ElementCollection // mandatory
	// how to specify name of table and FK clo name
	@CollectionTable(name="student_hobbies",joinColumns = @JoinColumn(name="student_id"))
	@Column(name="hobby",length=40,unique=true)
	private List<String> hobbies = new ArrayList<>();
	// uni dir asso bet entity and collection of composite values 
	@ElementCollection // optional but reccom
	@CollectionTable(name="student_qualification",joinColumns = @JoinColumn(name="student_id"))
	private List<EducationalQualification> qualifications = new ArrayList<>();
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<EducationalQualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<EducationalQualification> qualifications) {
		this.qualifications = qualifications;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public AdharCard getAdharCard() {
		return adharCard;
	}

	public void setAdharCard(AdharCard adharCard) {
		this.adharCard = adharCard;
	}

	public Course getChoseCourse() {
		return choseCourse;
	}
	public void setChoseCourse(Course choseCourse) {
		this.choseCourse = choseCourse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + "]";
	}
	
}
