package model.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the history_type database table.
 * 
 */
@Entity
@Table(name = "history_type")
@NamedQuery(name = "HistoryType.findAll", query = "SELECT h FROM HistoryType h")
public class HistoryType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;

	public HistoryType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}