package trello.domain.user;

import org.springframework.data.repository.CrudRepository;

public interface TrelloUserRepository extends CrudRepository<TrelloUser, Long>{
	TrelloUser findByUserId(String userId);
}
