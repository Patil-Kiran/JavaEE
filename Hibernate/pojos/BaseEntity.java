package pojos;

import javax.persistence.*;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//common to all entities 
// this will not create table in database but all implementing classes will create indivisual table in database
public class BaseEntity {
	// common data members 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
