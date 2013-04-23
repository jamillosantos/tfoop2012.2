package foodlink.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import foodlink.controllers.Actions;
import foodlink.exceptions.ValidationException;

public class OrderProduct extends Model {

	
	private int amount;
	private Date time;
	private Product product;
	
 	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public void validate(Actions action) throws ValidationException {
		List<String> errors = new ArrayList<String>();
		if (this.getProduct()==null)
			errors.add ("Selecione um Produto");
		if (amount <= 0)
			errors.add ("A quantidade deve ser maior que 0");
		if (!errors.isEmpty())
			throw new ValidationException(errors);
	}
}
