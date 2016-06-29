package trello.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListRepository  extends JpaRepository<List, Long>{
	Iterable<List> findByBoardId(long boardId);
}
