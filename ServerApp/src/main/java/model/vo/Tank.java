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
@NamedQuery(name="Tank.findByEstate",query="SELECT c FROM Tank c WHERE c.idEstate=:idEstate")
public class Tank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "capacity")
	private double capacity;
	@Column(name = "name")
	private String name;
	@Column(name = "id_estate")
	private int idEstate;
	
	@Override
	public String toString() {
		return "Tank [id=" + id + ", capacity=" + capacity + ", name=" + name + ", idEstate=" + idEstate + "]";
	}

	public int getIdEstate() {
		return idEstate;
	}

	public void setIdEstate(int idEstate) {
		this.idEstate = idEstate;
	}

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