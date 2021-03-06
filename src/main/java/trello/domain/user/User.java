package trello.domain.user;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
@Entity
@Data
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="USER_TYPE")    
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	
	private String userId;

	private String userEmail;
	
	public User() {
	}

	public User(String userId, String email) {
		this.userId = userId;
		this.userEmail = email;
	}

	
//	@Override
//	public User(String userId, String userPassword){
//		this(userId, userPassword);
//	}

}
