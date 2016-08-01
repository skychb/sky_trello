package trello.domain.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@DiscriminatorValue(value = UserType.Values.GITHUB)
public class GithubUser extends User{
	private String name;
	private String accessToken;
	
	public GithubUser() {
	}
	
	public GithubUser(String userId, String email, String name, String accessToken) {
		super(userId, email);
		this.name = name;
		this.accessToken = accessToken;
	}

	public String getName() {
		return name;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
}
