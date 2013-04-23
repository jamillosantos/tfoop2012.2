package foodlink;

import foodlink.controllers.*;

public class Db
{
	private CategoryController category;
	private OrderController order;
	private OrderProductController orderProduct;
	private ProductController product;
	private TableController table;
	private UserController user;

	public Db()
	{
		this.category = new CategoryController();
		this.order = new OrderController();
		this.orderProduct = new OrderProductController();
		this.product = new ProductController();
		this.table = new TableController();
		this.user = new UserController();
	}

	public CategoryController getCategory()
	{
		return this.category;
	}
	
	public OrderController getOrder()
	{
		return this.order;
	}

	public OrderProductController getOrderProduct()
	{
		return this.orderProduct;
	}

	public ProductController getProduct()
	{
		return this.product;
	}

	public TableController getTable()
	{
		return this.table;
	}

	public UserController getUser()
	{
		return this.user;
	}
}
