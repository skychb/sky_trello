package trello.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	
	@Column(name="userId", length=30, nullable = false)
	private String userId;

	@Column(name="userPassword", length=100, nullable = false)
	private String userPassword;

	@Column(name="userEmail", length=30, nullable = false)
	private String userEmail;
	
	public User() {
	}

	public User(int pid, String userId, String userPassword, String userEmail) {
		this.pid = pid;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
	}
	
	public User(String userId, String userPassword){
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public User(String userId, String userPassword, String email) {
		this(0, userId, userPassword, email);
	}
	
//	@Override
//	public User(String userId, String userPassword){
//		this(userId, userPassword);
//	}

}
