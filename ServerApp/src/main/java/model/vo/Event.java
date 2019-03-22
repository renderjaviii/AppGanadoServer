package model.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
@NamedQuery(name ="Event.findByUser", query= "SELECT c FROM Event c WHERE c.idEstate IN (SELECT DISTINCT e.id FROM Estate e, UserApp u WHERE e.phoneUser =: phone)")
@NamedQuery(name ="Event.findByEstate", query="SELECT c FROM Event c WHERE c.idEstate =: idEstate")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_estate")
	private Integer idEstate;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_")
	private Date date;
	@Column(name = "id_event_type")
	private Integer idEventType;
	@Column(name = "name")
	private String name;
	@Column(name = "details")
	private String details;
	@Column(name = "manager")
	private String manager;

	@Override
	public String toString() {
		return "Event [idEstate=" + idEstate + ", date=" + date + ", idEventType=" + idEventType + ", name=" + name
				+ ", details=" + details + ", manager=" + manager + "]";
	}

	public Event() {
	}

	public Integer getIdEstate() {
		return idEstate;
	}

	public void setIdEstate(Integer idEstate) {
		this.idEstate = idEstate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getIdEventType() {
		return idEventType;
	}

	public void setIdEventType(Integer idEventType) {
		this.idEventType = idEventType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}