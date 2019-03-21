package model.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the tank database table.
 * 
 */
@Entity
@NamedQuery(name = "Tank.findAll", query = "SELECT t FROM Tank t")
public class Tank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "capacity")
	private double capacity;
	@Column(name = "name")
	private String name;

	public Tank() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCapacity() {
		return this.capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}