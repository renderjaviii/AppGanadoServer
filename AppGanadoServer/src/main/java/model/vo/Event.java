package model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
@NamedQuery(name = "Event.findByUser", query = "SELECT c FROM Event c WHERE c.idEstate IN (SELECT DISTINCT e.id FROM Estate e, UserApp u WHERE e.phoneUser = ?1)"),
@NamedQuery(name = "Event.findByEstate", query = "SELECT c FROM Event c WHERE c.idEstate = ?1")})
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_")
	private Date date;

	@Column(name="details")
	private String details;

	@Column(name="id_estate")
	private Integer idEstate;

	@Column(name="id_event_type")
	private Integer idEventType;

	@Column(name="manager")
	private String manager;

	@Column(name="name")
	private String name;

	public Event() {
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

	public Integer getIdEstate() {
		return this.idEstate;
	}

	public void setIdEstate(Integer idEstate) {
		this.idEstate = idEstate;
	}

	public Integer getIdEventType() {
		return this.idEventType;
	}

	public void setIdEventType(Integer idEventType) {
		this.idEventType = idEventType;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}