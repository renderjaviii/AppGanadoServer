package model.dao;

import model.vo.Lot;
import util.FacadePersistence;

public class LotDAO extends FacadePersistence<Lot> {
	private static FacadePersistence<Lot> facadePersistence;

	public LotDAO(Class<Lot> entityReference) {
		super(entityReference);
		facadePersistence = new FacadePersistence<Lot>(entityReference);
	}
}
