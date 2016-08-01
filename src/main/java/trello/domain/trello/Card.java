package trello.domain.trello;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "card")
public class Card implements Serializable{
	private static Card card = null;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cardId;
	@Column(name = "cardName", length=70, nullable=false)
	private String cardName;
	@Column(name="description", length=5000, nullable=true)
	private String description;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_card_parent_id"))
	private List list;
	
	
	public Card(String cardName, String description, List list){
		this.cardName = cardName;
		this.description = description;
		this.list = list;
		list.addCard(this);
	}
	
	public Card(){};
	
}
