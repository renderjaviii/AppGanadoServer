package model.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the estate database table.
 * 
 */
@Entity
@NamedQuery(name = "Estate.findAll", query = "SELECT e FROM Estate e")
@NamedQuery(name = "Estate.findByUser", query = "SELECT e FROM Estate e WHERE phone_user =: phone") // Get user's
																									// estates

public class Estate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "area")
	private Double area;
	@Column(name = "location")
	private String location;
	@Column(name = "name")
	private String name;
	@Column(name = "photo")
	private Byte[] photo;
	@Column(name = "phone_user")
	private Long phoneUser;

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

	public Byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}

	public Long getPhoneUser() {
		return phoneUser;
	}

	public void setPhoneUser(Long phoneUser) {
		this.phoneUser = phoneUser;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "{ id: " + getId() + ", name: " + getName() + ", phoneUser:  " + getPhoneUser() + "}";
	}
}