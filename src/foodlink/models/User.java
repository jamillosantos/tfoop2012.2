package foodlink.models;

import java.util.ArrayList;
import java.util.List;

import foodlink.controllers.Actions;
import foodlink.exceptions.ValidationException;

public class User extends Model implements IdentificableModel {

	
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
	@Override
	public void validate(Actions action) throws ValidationException {
		List<String> errors = new ArrayList<String>();
		if (this.getName() == null)
			errors.add ("Deve ser expecificado um nome para o usuário.");
		if (this.getId() <= 0)
			errors.add ("O ID do usuário não foi gerado corretamente.");
		if (this.getPassword()==null)
			errors.add("A senha não pode estar em branco");
		if (!errors.isEmpty())
			throw new ValidationException(errors);

	}
}
