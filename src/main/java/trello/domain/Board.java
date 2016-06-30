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
@Data
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

	@Override
	public String toString() {
		return "Board [id=" + id + ", boardName=" + boardName + "]";
	}

}