package trello.domain.trello;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@OneToMany(mappedBy = "board")
	private java.util.List<List> lists;
	
	public Board(String boardName) {
		this.boardName = boardName;
	}

	public Board() {
	};


}