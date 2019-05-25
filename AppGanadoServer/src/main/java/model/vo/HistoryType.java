package model.vo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the history_type database table.
 * 
 */
@Entity
@Table(name="history_type")
@NamedQuery(name="HistoryType.findAll", query="SELECT h FROM HistoryType h")
public class HistoryType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="name")
	private String name;

	@Column(name="phone_user")
	private Long phoneUser;

	public HistoryType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}