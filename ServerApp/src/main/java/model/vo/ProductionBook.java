package model.vo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the production_book database table.
 * 
 */
@Entity
@Table(name="production_book")
@NamedQuery(name="ProductionBook.findAll", query="SELECT p FROM ProductionBook p")
public class ProductionBook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tank")
	private Integer idTank;
	@Temporal(TemporalType.DATE)
	@Column(name="date_")
	private Date date;
	@Column(name = "production")
	private double production;

	public ProductionBook() {
	}

	public Integer getIdTank() {
		return this.idTank;
	}

	public void setIdTank(Integer idTank) {
		this.idTank = idTank;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getProduction() {
		return this.production;
	}

	public void setProduction(double production) {
		this.production = production;
	}

}