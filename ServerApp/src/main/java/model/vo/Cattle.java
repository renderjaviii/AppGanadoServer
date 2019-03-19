package model.vo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the cattle database table.
 * 
 */
@Entity
@NamedQuery(name = "Cattle.findAll", query = "SELECT c FROM Cattle c")
public class Cattle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "age")
	private Integer age;
	@Column(name = "details")
	private String details;
	@Column(name = "id_breed")
	private Integer idBreed;
	@Column(name = "id_gender")
	private Integer idGender;
	@Column(name = "id_lot")
	private Integer idLot;
	@Column(name = "id_purpose")
	private Integer idPurpose;
	@Column(name = "name")
	private String name;
	@Column(name = "photo")
	private byte[] photo;
	@Column(name = "weight")
	private double weight;

	public Cattle() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getIdBreed() {
		return this.idBreed;
	}

	public void setIdBreed(Integer idBreed) {
		this.idBreed = idBreed;
	}

	public Integer getIdGender() {
		return this.idGender;
	}

	public void setIdGender(Integer idGender) {
		this.idGender = idGender;
	}

	public Integer getIdLot() {
		return this.idLot;
	}

	public void setIdLot(Integer idLot) {
		this.idLot = idLot;
	}

	public Integer getIdPurpose() {
		return this.idPurpose;
	}

	public void setIdPurpose(Integer idPurpose) {
		this.idPurpose = idPurpose;
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

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}