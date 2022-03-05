package pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class EducationalQualification {
	@Enumerated(EnumType.STRING) // enum represent singleTon instance
	@Column(length=  20)
	private EducationType type;
	private int year;
	private int marks;
	
	public EducationalQualification() {

	}

	public EducationalQualification(EducationType type, int year, int marks) {
		super();
		this.type = type;
		this.year = year;
		this.marks = marks;
	}

	public EducationType getType() {
		return type;
	}

	public void setType(EducationType type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "EducationalQualification [type=" + type + ", year=" + year + ", marks=" + marks + "]";
	}
	
	
}
