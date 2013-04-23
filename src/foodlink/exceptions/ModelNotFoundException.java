package foodlink.exceptions;

import foodlink.models.Model;

public class ModelNotFoundException extends Exception
{
	private static final long serialVersionUID = 1481187782545055076L;

	private Model model;

	public ModelNotFoundException(Model model)
	{
		super("O modelo não foi encontrado.");
		this.model = model;
	}

	public Model getModel()
	{
		return this.model;
	}
}
