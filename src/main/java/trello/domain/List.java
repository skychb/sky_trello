package trello.domain;

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
@Table(name = "list")
public class List implements Serializable{
	private static List list = null;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "listName", length=70, nullable=false)
	private String listName;
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_list_parent_id"))
	private Board board;
	
	public List(){};
	
	public List(String listName){

		this.listName = listName;
	}
	
	
	public static List getList(){
		return list;
	}

	public long getId() {
		return id;
	}

	public String getListName() {
		return listName;
	}
	
	
	
	@Override
	public String toString() {
		return "List [id=" + id + ", listName=" + listName +"]";
	}
	
}
