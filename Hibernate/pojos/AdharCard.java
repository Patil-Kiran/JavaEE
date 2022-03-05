package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// Adhar never extends baseEntity purely depends upon students
// how to tell hibernate following class has no separate existence and content embedded in owning entity
// Entity ---> Value uni dir Entity to Value type
// CANNOT BE USED IN JPQL DIRECTLY

@Embeddable
public class AdharCard {
	@Column(name="card_number",unique=true,length=20)
	 private String cardNumber;
	@Column(name="creation_date")
	 private LocalDate creationDate;
	@Column(length=30)
	 private String Location;
	 
	 public AdharCard() {

	}
	 
	public AdharCard(String cardNumber, LocalDate creationDate, String location) {
		super();
		this.cardNumber = cardNumber;
		this.creationDate = creationDate;
		Location = location;
	}



	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	@Override
	public String toString() {
		return "AdharCard [cardNumber=" + cardNumber + ", creationDate=" + creationDate + ", Location=" + Location
				+ "]";
	}
	 
	 
}
