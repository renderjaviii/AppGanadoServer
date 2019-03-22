package model.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the cattle_history_book database table.
 * 
 */
@Entity
@Table(name = "cattle_history_book")
@NamedQuery(name = "CattleHistoryBook.findAll", query = "SELECT c FROM CattleHistoryBook c")
@NamedQuery(name="CattleHistoryBook.findByEstate", query ="SELECT c FROM CattleHistoryBook c WHERE c.idCattle=:idCattle")
public class CattleHistoryBook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_")
	private Date date;
	@Column(name = "details")
	private String details;
	@Column(name = "id_cattle")
	private Integer idCattle;
	@Column(name = "id_history_type")
	private Integer idHistoryType;
	@Column(name = "namehistory")
	private String namehistory;

	public CattleHistoryBook() {
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

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getIdCattle() {
		return this.idCattle;
	}

	public void setIdCattle(Integer idCattle) {
		this.idCattle = idCattle;
	}

	public Integer getIdHistoryType() {
		return this.idHistoryType;
	}

	public void setIdHistoryType(Integer idHistoryType) {
		this.idHistoryType = idHistoryType;
	}

	public String getNamehistory() {
		return this.namehistory;
	}

	public void setNamehistory(String namehistory) {
		this.namehistory = namehistory;
	}

}