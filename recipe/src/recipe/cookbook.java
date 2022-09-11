package recipe;

import java.util.ArrayList;  
public class cookbook  
{
	private ArrayList<recipe>recipes;
	
	public void Cookbook()
	{
		recipes = new ArrayList<recipe>();
	}
	public void addRecipe(recipe r)
	{
		recipes.add(r);
	}
	public recipe getRecipe(int index)
	{
		return recipes.get(index);
	}
}