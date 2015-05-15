package es.upm.fi.emse;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	AssemblyLine assemblyLine = new AssemblyLine();
		List<Recipe> recipes = new ArrayList<Recipe>();

		Game game = new Game(assemblyLine, recipes);
		game.start();
    }
}
