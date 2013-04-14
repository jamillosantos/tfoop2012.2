package models;

import java.util.ArrayList;
import java.util.List;

import controllers.Actions;
import exceptions.ValidationException;

public class Product extends Model
{
	private int id;
	private Category category;
	private String name;
	private int price;
	private int amount;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public void validate(Actions action) throws ValidationException 
	{
		List<String> errors = new ArrayList<String>();
		
		if(this.getName().isEmpty())
			errors.add("O nome deve ser preenchido!");
		
		if(this.getAmount() <= 0)
			errors.add("A quantidade deve ser maior que zero!");
			
		if(this.getCategory() == null)
			errors.add("Escolha uma categoria!");
		
		if(this.getPrice() < 0)
			errors.add("Preço inválido!");		
		
		if(!errors.isEmpty())
			throw new ValidationException(errors);
	}

}
