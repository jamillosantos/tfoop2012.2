package foodlink.models;

import foodlink.controllers.Actions;
import foodlink.exceptions.ValidationException;

public class Table extends Model implements IdentificableModel {

	private int id;
	
	@Override
	public void validate(Actions action) throws ValidationException {
		// TODO Auto-generated method stub

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
