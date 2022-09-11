package recipe;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class readrecipe
{  
public static void main(String args[])  
	{  
		try  
		{   
			FileInputStream fis=new FileInputStream("recipes.txt");       
			Scanner sc=new Scanner(fis);      

			while(sc.hasNextLine())  
			{  
				System.out.println(sc.nextLine()); 
			}  
			sc.close();    
			}  
		catch(IOException e)  
		{  
			e.printStackTrace();  
		}  
	}  
}  
