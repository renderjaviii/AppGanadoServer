package model.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tank database table.
 * 
 */
@Entity
@NamedQuery(name = "Tank.findAll", query = "SELECT t FROM Tank t")
@NamedQuery(name = "Tank.findByEstate", query = "SELECT c FROM Tank c WHERE c.idEstate=:idEstate")
public class Tank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="capacity")
	private Double capacity;
	@Column(name="id_estate")
	private Integer idEstate;
	@Column(name="name")
	private String name;

	public Tank() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public Integer getIdEstate() {
		return this.idEstate;
	}

	public void setIdEstate(Integer idEstate) {
		this.idEstate = idEstate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}