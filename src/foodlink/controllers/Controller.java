package foodlink.controllers;

import java.util.ArrayList;
import java.util.List;

import foodlink.exceptions.ModelNotFoundException;
import foodlink.exceptions.ValidationException;
import foodlink.models.IdentificableModel;
import foodlink.models.Model;


public class Controller<T extends Model>
{
	/**
	 * Guarda as instâncias de todos os modelos <T> criados.
	 */
	private List<T> models;

	private int lastId;

	public Controller()
	{
		this.models = this.createModels();
		this.lastId = 0;
	}

	/**
	 * @return Retorna o inteiro identificador do último objeto inserido.
	 */
	protected int getLastId()
	{
		return this.lastId;
	}

	/**
	 * Cria e retorna a instância da lista que será utilizada pela
	 * variável models.
	 * 
	 * @see foodlink.models
	 * @return
	 */
	protected List<T> createModels()
	{
		return new ArrayList<T>();
	}	
	
	public void insert(T model) throws ValidationException
	{
		model.validate(Actions.insert);
		this.models.add(model);
		if(model instanceof IdentificableModel){
			((IdentificableModel)model).setId(this.lastId);
			this.lastId ++;
		}
	}

	public void remove(T model) throws ModelNotFoundException
	{
		if (!this.models.remove(model))
			throw new ModelNotFoundException(model); 
	}

	public void update(T searchModel, T updateModel) throws ValidationException, ModelNotFoundException
	{
		updateModel.validate(Actions.update);
		int i = this.models.indexOf(searchModel);
		if (i > -1)
			this.models.set(i, updateModel);
		else
			throw new ModelNotFoundException(searchModel);
	}

	public List<T> collect(Collector<T> collector)
	{
		List<T> result = this.createModels();
		for (T model : this.models)
		{
			if (collector.collect(model))
				result.add(model);
		}
		return result;
	}

	public T collectFirst(Collector<T> collector)
	{
		for (T model : this.models)
		{
			if (collector.collect(model))
				return model;
		}
		return null;
	}
}
