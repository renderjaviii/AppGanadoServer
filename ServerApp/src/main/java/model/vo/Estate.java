package model.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the estate database table.
 * 
 */
@Entity
@NamedQuery(name = "Estate.findAll", query = "SELECT e FROM Estate e")
public class Estate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "area")
	private double area;
	@Column(name = "location")
	private String location;
	@Column(name = "name")
	private String name;
	@Column(name = "photo")
	private byte[] photo;

	public Estate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getArea() {
		return this.area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}