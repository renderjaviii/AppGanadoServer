package model.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lot database table.
 * 
 */
@Entity
@NamedQuery(name="Lot.findAll", query="SELECT l FROM Lot l")
public class Lot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="name")
	private String name;

	public Lot() {
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