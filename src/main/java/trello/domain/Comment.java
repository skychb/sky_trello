package trello.domain;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name = "comment")
public class Comment implements Serializable{
	private static Comment comment = null;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long commentId;
	
	private Timestamp timeStamp;
	
	@Column(name="userName", length=100)
	private String userName;
	
	@Column(name = "content", length=1000, nullable=false)
	private String content;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_comment_parent_id"))
	private Card card;
	
	public Comment(Timestamp timeStamp, String userName, Card card, String content){
		this.timeStamp = timeStamp;
		this.userName = userName;
		this.content = content;
		this.card = card;
	}
	
	public Comment(){};
	
}
