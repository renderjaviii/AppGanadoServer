package model.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the purpose database table.
 * 
 */
@Entity
@NamedQuery(name="Purpose.findAll", query="SELECT p FROM Purpose p")
public class Purpose implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;

	public Purpose() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}