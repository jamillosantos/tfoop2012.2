package foodlink.controllers;

import java.util.List;

import foodlink.models.Category;
import foodlink.models.Product;


class ProductByCategoryCollector extends Collector<Product>{
	private Category category;
	
	public ProductByCategoryCollector(Category category){
		this.setCategory(category);
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public boolean collect(Product model){
		return (model.getCategory().equals(this.getCategory()));
	}
}

class ProductByNameCollector extends Collector<Product>{
	private String search;

	public ProductByNameCollector(String search)
	{
		this.setSearch(search);
	}

	public String getSearch()
	{
		return this.search;
	}

	public void setSearch(String search)
	{
		this.search = search;
	}

	public boolean collect(Product model){
		return model.getName().contains(this.getSearch());
	}
}

public class ProductController extends Controller<Product> {
	
	public List<Product> collectByCategory(Category category)
	{
		return this.collect(new ProductByCategoryCollector(category));
	}
	
	public List<Product> collectByName(String search)
	{
		return this.collect(new ProductByNameCollector(search));
	}
	
}
