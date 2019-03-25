package model.vo;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;


/**
 * The persistent class for the user_app database table.
 * 
 */
@Entity
@Table(name = "user_app")
@NamedQuery(name = "UserApp.findAll", query = "SELECT u FROM UserApp u")
@NamedQuery(name = "UserApp.login", query = "SELECT u FROM UserApp u WHERE phone =: phone AND password =: password")
public class UserApp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="phone")
	private Long phone;
	@Column(name="email")
	private String email;
	@Column(name="id_rol")
	private Integer idRol;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="photo")
	private Byte[] photo;

	public UserApp() {
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return String.format("UserApp [phone=%s, email=%s, idRol=%s, name=%s, password=%s, photo=%s]", phone, email,
				idRol, name, password, Arrays.toString(photo));
	}

	

	
}