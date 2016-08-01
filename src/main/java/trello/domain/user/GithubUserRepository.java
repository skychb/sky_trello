package trello.domain.user;

import org.springframework.data.repository.CrudRepository;

public interface GithubUserRepository extends CrudRepository<GithubUser, Long>{
	GithubUser findByAccessToken(String accessToken);
	GithubUser findByUserId(String userId);
}
