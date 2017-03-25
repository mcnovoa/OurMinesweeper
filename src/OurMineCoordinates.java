import java.awt.Color;
import java.util.Random;

public class OurMineCoordinates
{
	public static boolean[][] mineField = new boolean[9][9];
	public static boolean[][] flaggedCell = new boolean[9][9];
	public Color[][] colorArray = new Color[9][9];
	private Random generator = new Random();
	public static int totalMines = 10;
	
//	Generates the mines on the panel
	public void createMines()
	{
		int setMines = 0;
		while (setMines < totalMines) 
		{
			int column = generator.nextInt(9);
			int row = generator.nextInt(9);
			if (mineField[column][row] == false) 
			{
				Color setColor = Color.BLACK;
				mineField[column][row] = true;
				setMines++;
				
				System.out.println("Mine has been set in mineField["+row+"]["+column+"]");
			}
		}
	}
	
	public boolean mineFound(int x, int y)
	{
		return mineField[x][y];
	}
	
//	public boolean gameLost()
//	{
//		
//	}
}