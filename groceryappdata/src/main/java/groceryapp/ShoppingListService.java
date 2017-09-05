package groceryapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service 
public class ShoppingListService {
	
	@Autowired
	private ShoppingListRepository repository; 
	
	private List<ShoppingList> shoppingLists;
	
	public ShoppingListService() {
		
		this.shoppingLists = new ArrayList<ShoppingList>(); 
		
		this.shoppingLists.add(new ShoppingList(1,"HEB")); 
		this.shoppingLists.add(new ShoppingList(2,"Walmart"));
		this.shoppingLists.add(new ShoppingList(3,"Fiesta")); 
	} 
	
	public void deleteShoppingList(int shoppingListId) {
		
		ShoppingList shoppingList = this.repository.findOne(shoppingListId);
		this.repository.delete(shoppingList);

	}
	
	public void updateShoppingList(ShoppingList shoppingList) {
		
		ShoppingList persistedShoppingList = getShoppingListById(shoppingList.getShoppingListId());
		persistedShoppingList.setTitle(shoppingList.getTitle());
		this.repository.save(persistedShoppingList);
	}
	
	public void addShoppingList(ShoppingList shoppingList) {
		this.repository.save(shoppingList);
	}
	
	public ShoppingList getShoppingListById(int shoppingListId) {
		
		return this.repository.findOne(shoppingListId);	
	}

	public List<ShoppingList> getAllShoppingLists() {
		
		List<ShoppingList> shoppingLists = new ArrayList<>(); 
		this.repository.findAll()
		.forEach(shoppingLists::add);
		
		return shoppingLists; 
		
		//return this.shoppingLists; 
	}
	
}
