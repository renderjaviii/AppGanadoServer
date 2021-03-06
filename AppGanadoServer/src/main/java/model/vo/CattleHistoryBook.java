package model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cattle_history_book database table.
 * 
 */
@Entity
@Table(name = "cattle_history_book")
@NamedQueries({@NamedQuery(name = "CattleHistoryBook.findAll", query = "SELECT c FROM CattleHistoryBook c"),
    @NamedQuery(name = "CattleHistoryBook.findByEstate", query = "SELECT c FROM CattleHistoryBook c WHERE c.idCattle = ?1")})
public class CattleHistoryBook implements Serializable {
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

	@Column(name="id_cattle")
	private Integer idCattle;

	@Column(name="id_history_type")
	private Integer idHistoryType;

	

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
}