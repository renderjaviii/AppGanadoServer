package model.dao;

import model.vo.Breed;
import util.FacadePersistence;

public class BreedDAO extends FacadePersistence<Breed> {
	private static FacadePersistence<Breed> facadePersistence;

	public BreedDAO(Class<Breed> entityReference) {
		super(entityReference);
		facadePersistence = new FacadePersistence<Breed>(entityReference);
	}

}
