package trello.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "board")
public class Board {

	private static Board board = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="boardName", length=50, nullable=false)
	private String boardName;

	public Board(String boardName) {
		this.boardName = boardName;
	}

	public static Board getBoard() {
		return board;
	}

	public long getId() {
		return id;
	}

	public String getBoardName() {
		return boardName;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", boardName=" + boardName + "]";
	}

}