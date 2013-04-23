package foodlink.models;

import foodlink.controllers.Actions;
import foodlink.exceptions.ValidationException;

public abstract class Model
{
	public abstract void validate(Actions action) throws ValidationException;
}
