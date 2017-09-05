package groceryapp;

import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepository extends CrudRepository<ShoppingList,Integer> {

	// getAllShoppingLists 
	// getShoppingList(int shoppingListId) 
	// updateShoppingList(ShoppingList shoppingList) 
}
