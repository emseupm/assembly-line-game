package es.upm.fi.emse;


public class App 
{
    public static void main( String[] args )
    {
    	AssemblyLine assemblyLine = new AssemblyLine();

		Game game = new Game(assemblyLine);
		game.start();
    }
}
