package models;

import controllers.Actions;
import exceptions.ValidationException;

public class Order extends Model implements IdentificableModel {

	@Override
	public void validate(Actions action) throws ValidationException {
		// TODO Auto-generated method stub

	}
	
	private int id;
	private Table table;
	private User waiter;
	
	public int getId() {
		return id;
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public User getWaiter() {
		return waiter;
	}
	public void setWaiter(User waiter) {
		this.waiter = waiter;
	}

}