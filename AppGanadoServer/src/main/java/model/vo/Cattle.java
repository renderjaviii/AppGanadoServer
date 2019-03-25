package model.vo;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;

/**
 * The persistent class for the cattle database table.
 * 
 */
@Entity
@NamedQuery(name = "Cattle.findAll", query = "SELECT c FROM Cattle c")
@NamedQuery(name = "Cattle.findByUser", query = "SELECT c FROM Cattle c WHERE c.idEstate IN (SELECT DISTINCT e.id FROM Estate e, UserApp u WHERE e.phoneUser =: phone)") // Get user's  estate
@NamedQuery(name = "Cattle.findByEstate", query = "SELECT c FROM Cattle c WHERE c.idEstate =: idEstate")
@NamedQuery(name = "Cattle.findOne", query = "SELECT c FROM Cattle c WHERE c.code =: code AND c.idEstate =: idEstate")
public class Cattle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "age")
	private Integer age;

	@Column(name = "code")
	private Integer code;

	@Column(name = "details")
	private String details;

	@Column(name = "id_breed")
	private Integer idBreed;

	@Column(name = "id_estate")
	private Integer idEstate;

	@Column(name = "id_gender")
	private Integer idGender;

	@Column(name = "id_lot")
	private Integer idLot;

	@Column(name = "id_purpose")
	private Integer idPurpose;

	@Column(name = "name")
	private String name;

	@Column(name = "photo")
	private Byte[] photo;

	@Column(name = "weight")
	private Double weight;

	public Cattle() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
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

	public Integer getIdEstate() {
		return this.idEstate;
	}

	public void setIdEstate(Integer idEstate) {
		this.idEstate = idEstate;
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

	public Byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return String.format(
				"Cattle [id=%s, age=%s, code=%s, details=%s, idBreed=%s, idEstate=%s, idGender=%s, idLot=%s, idPurpose=%s, name=%s, photo=%s, weight=%s]",
				id, age, code, details, idBreed, idEstate, idGender, idLot, idPurpose, name, Arrays.toString(photo),
				weight);
	}

}