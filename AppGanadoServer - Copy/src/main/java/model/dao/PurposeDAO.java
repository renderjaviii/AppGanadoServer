package model.dao;

import model.vo.Purpose;
import util.FacadePersistence;

public class PurposeDAO extends FacadePersistence<Purpose> {

	private FacadePersistence<Purpose> facadePersistence;

	public PurposeDAO(Class<Purpose> entityReference) {
		super(entityReference);
		facadePersistence = new FacadePersistence<Purpose>(entityReference);
	}
}
