package models;

import controllers.Actions;
import exceptions.ValidationException;

public abstract class Model
{
	public abstract void validate(Actions action) throws ValidationException;
}
