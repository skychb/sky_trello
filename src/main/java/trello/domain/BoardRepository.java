package trello.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends JpaRepository<Board, Long>{
}
