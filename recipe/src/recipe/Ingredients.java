package recipe;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Ingredients {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		ArrayList<String> ingredients = new ArrayList<String>();
		System.out.print("Enter your ingredients ");
		String line = in.nextLine();
		String[] data = line.split(", ");
		for (String s : data)
			ingredients.add(s);

		in.close();
		
		for(String s: ingredients)
			System.out.println(s);
		
		ArrayList<recipe> allRecipes = ReadAllRecipes("recipes.txt");
		 
		ArrayList<recipe> validRecipe = SearchRecipe(ingredients, allRecipes);
		
		 for(recipe currentRecipe : validRecipe) {
             System.out.println("This is the recipe for " + currentRecipe.getRecipeName());
         
             for(String ingredient : currentRecipe.getIngredients()) {
                 System.out.println("Ingredient: " + ingredient);
             }
		 }
		 
	}
	
	public static ArrayList<recipe> ReadAllRecipes(String filePath) {
        ArrayList<recipe> recipes = new ArrayList<recipe>();
        ArrayList<String> ingredients = new ArrayList<String>();
        
        try {
            FileReader readFile = new FileReader(new File("recipes.txt"));
            BufferedReader br = new BufferedReader(readFile);

            String line, recipeName = "";
            Boolean newRecipe = true;
            while((line = br.readLine()) != null) {
                if(line.equals("~")) { 
                    ArrayList<String> recipeIngred = new ArrayList<String>();
                    recipeIngred.addAll(ingredients);
                    recipes.add(new recipe(recipeName, recipeIngred));
                    ingredients.clear(); 
                    
                    newRecipe = true;
                }else if(newRecipe) { 
                    recipeName = line;
                    newRecipe = false;
                }else { 
                    ingredients.add(line);
                }
            }
            
            readFile.close();
        }catch(IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
		return recipes; 
	}
	
	public static ArrayList<recipe> SearchRecipe(ArrayList<String> personalIngredients, ArrayList<recipe> allRecipes) {
	    ArrayList<recipe> validRecipes = new ArrayList<recipe>();
	    
	    for(recipe currentRecipe : allRecipes) {
	        Boolean ingredientsPresent = true;
	        
	        for(String ingredient : currentRecipe.getIngredients()) {
	            Boolean foundCurIngredient = false;
	            for(String myIngredient : personalIngredients) {
	                if(myIngredient.equals(ingredient)) { //I do have that
	                    foundCurIngredient = true;
	                    break;
	                }
	            }
	            
	            //Did not find current ingredient, this recipe does not work.
	            if(!foundCurIngredient) {
	                ingredientsPresent = false;
	                break;
	            }
	        }
	        
	        if(ingredientsPresent) {
	            validRecipes.add(currentRecipe);
	        }
	    }
	    
	    return validRecipes;
	}
	
}
