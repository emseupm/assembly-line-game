package es.upm.fi.emse;

import javax.swing.SwingUtilities;

public class App 
{
    public static void main( String[] args )
    {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AssemblyLine assemblyLine = new AssemblyLine();

				Game game = new Game(assemblyLine);
				game.start();
			}
		});
    }
}
