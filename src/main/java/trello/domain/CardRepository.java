package trello.domain;

import org.springframework.data.repository.CrudRepository;

import trello.domain.Card;

public interface CardRepository extends CrudRepository<Card, Long> {
	
}
