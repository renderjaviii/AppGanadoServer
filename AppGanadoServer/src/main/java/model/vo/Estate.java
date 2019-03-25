package model.vo;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;

/**
 * The persistent class for the estate database table.
 * 
 */
@Entity
@NamedQuery(name = "Estate.findAll", query = "SELECT e FROM Estate e")
@NamedQuery(name = "Estate.findByUser", query = "SELECT e FROM Estate e WHERE phoneUser =: phone") // Get user's estates
@NamedQuery(name = "Estate.findOne", query = "SELECT e FROM Estate e WHERE e.name =: name AND e.phoneUser =: phone")
public class Estate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "area")
	private Double area;

	@Column(name = "location")
	private String location;

	@Column(name = "name")
	private String name;

	@Column(name = "phone_user")
	private Long phoneUser;

	@Column(name = "photo")
	private Byte[] photo;

	public Estate() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public Long getPhoneUser() {
		return this.phoneUser;
	}

	public void setPhoneUser(Long phoneUser) {
		this.phoneUser = phoneUser;
	}

	public Byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return String.format("Estate [id=%s, area=%s, location=%s, name=%s, phoneUser=%s, photo=%s]", id, area,
				location, name, phoneUser, Arrays.toString(photo));
	}

}