package groceryapp;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingListController {
	
	@Autowired
	private ShoppingListService service; 
	
	private List<ShoppingList> shoppingLists = Arrays.asList(
			new ShoppingList("HEB"), 
			new ShoppingList("Walmart") 
			);
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/shoppinglist")
	public void updateShoppingList(@RequestBody ShoppingList shoppingList) {
		this.service.updateShoppingList(shoppingList);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/shoppinglist")
	public void deleteShoppingList(@RequestBody ShoppingList shoppingList) {
		this.service.deleteShoppingList(shoppingList.getShoppingListId());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/shoppinglist")
	public void addShoppingList(@RequestBody ShoppingList shoppingList) {
		 this.service.addShoppingList(shoppingList); 
	}
	
	@RequestMapping("/shoppinglist/{shoppingListId}")
	public ShoppingList getShoppingList(@PathVariable int shoppingListId) {
		return this.service.getShoppingListById(shoppingListId); 
	}
	
	@RequestMapping("/shoppinglists")
	public List<ShoppingList> getShoppingLists() {
		
		return this.service.getAllShoppingLists();
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello World"; 
	}
	
}
