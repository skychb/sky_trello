package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Card {
	private static Card card = null;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String cardName;
	private String description;
	
	
	public Card(String cardName, String description){
		this.cardName = cardName;
		this.description = description;
	}
	
	public static Card getCard(){
		return card;
	}

	public long getId() {
		return id;
	}

	public String getCardName() {
		return cardName;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", cardName=" + cardName + ", description=" + description + "]";
	}
	
}
