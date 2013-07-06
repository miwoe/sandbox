package mwoelm.archetype.jee.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersistableObject {
	@Id
	private int id;
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
