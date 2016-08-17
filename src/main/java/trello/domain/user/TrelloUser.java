package trello.domain.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;


@Entity
@Data
@DiscriminatorValue(value = UserType.Values.TRELLO)
public class TrelloUser extends User{
	private String password;
	@Transient
	private String rawPassword;
	
	public TrelloUser(){
	}
	
	public TrelloUser(String userId, String email, String password){
		super(userId, email);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void encodePassword(PasswordEncoder passwordEncoder) {
		System.out.println("raw="+rawPassword);
		this.password = passwordEncoder.encode(rawPassword);
	}
}
