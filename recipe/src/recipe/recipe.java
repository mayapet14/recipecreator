package recipe;

import java.util.ArrayList;

public class recipe
{
	
	private String recipeName;
	private ArrayList<String> ingredients;
	
	public recipe()
	{
		ingredients = new ArrayList<String>();
	}
	
	public recipe(String RecipeName, ArrayList<String> ingrid) {
		recipeName = RecipeName;
		ingredients = ingrid;
	}
	
	public void addIngredient(String ingredient)
	{
		ingredients.add(ingredient);
	}
	
	public boolean contains(String ingredient)
	{
		return ingredients.contains(ingredient);
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public ArrayList<String> getIngredients() {
		return ingredients;
	}


	

}