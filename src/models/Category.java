package models;

import java.util.ArrayList;
import java.util.List;

import controllers.Actions;
import exceptions.ValidationException;

public class Category extends Model 
{
	private String name;
	
	@Override
	public void validate(Actions action) throws ValidationException
	{
		List<String> errors = new ArrayList<String>();

		if (this.getName().isEmpty())			
			errors.add("O nome deve ser preenchido.");
			
		if (!errors.isEmpty())			
			throw new ValidationException(errors);			
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
