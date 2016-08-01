package trello.domain.trello;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "list")
public class List implements Serializable {
	private static List list = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long listId;
	
	@Column(name = "listName", length = 70, nullable = false)
	private String listName;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_list_parent_id"))
	private Board board;

	@JsonIgnore
	@OneToMany(mappedBy = "list", fetch=FetchType.LAZY)
	private java.util.List<Card> cards = new ArrayList<>();
	
	public List() {
	};

	public List(String listName, Board board) {
		this.listName = listName;
		this.board = board;
	}
	
	public void addCard(Card card){
		cards.add(card);
	}
}
