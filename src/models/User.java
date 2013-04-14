package models;

import controllers.Actions;
import exceptions.ValidationException;

public class User extends Model implements IdentificableModel {

	@Override
	public void validate(Actions action) throws ValidationException {
		// TODO Auto-generated method stub

	}
	private int id;
	
	private String name;
	
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
