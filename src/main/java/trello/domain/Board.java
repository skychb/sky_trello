package trello.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "board")
public class Board implements Serializable{

	private static Board board = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "boardName", length = 50, nullable = false)
	private String boardName;

	public Board(String boardName) {
		this.boardName = boardName;
	}

	public Board() {
	};

	public static Board getBoard() {
		return board;
	}

	public long getId() {
		return id;
	}

	public String getBoardName() {
		return boardName;
	}

	public static void setBoard(Board board) {
		Board.board = board;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", boardName=" + boardName + "]";
	}

}