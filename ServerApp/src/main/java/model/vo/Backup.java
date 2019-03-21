package model.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the backup database table.
 * 
 */
@Entity
@NamedQuery(name = "Backup.findAll", query = "SELECT b FROM Backup b")
public class Backup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "date_")
	private Date date;

	@Column(name = "phone_user")
	private Integer phoneUser;

	public Backup() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPhoneUser() {
		return this.phoneUser;
	}

	public void setPhoneUser(Integer phoneUser) {
		this.phoneUser = phoneUser;
	}

}