import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class OurMineCoordinates
{
	public static boolean[][] mineField = new boolean[9][9];
	public static boolean[][] flaggedCell = new boolean[9][9];
	public static Color[][] colorArray = new Color[9][10];
	private Random generator = new Random();
	
	public static int totalMines = 10;
	
	
	public static Color[][] getColorField() 
	{
		return colorArray;
	}
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
				
//				"Println" was used to corroborate if and where the mines were placed
//				System.out.println("Mine has been set in mineField["+row+"]["+column+"]"); 
			}
		}
	}
	
//	find mines on board in order to use with other methods
	public boolean mineFound(int x, int y)
	{
		return mineField[x][y];
	}
	
//	find uncovered cells on board in order to use with other methods
	public boolean grayCell(int x, int y) 
	{
		if (colorArray[x][y].equals(Color.GRAY)) 
		{
			return true;
		}
		return false;
	}
	
//	puts the numbers of nearby mines inside the cells
	public int numbersInCells(int x, int y){
			int Counter = 0;

			for (int i = y - 1; i < y + 2; i++) 
			{
				for (int j = x - 1; j < x + 2; j++)
					{
					
					if ((i >= 0 && i < 9) && (j >= 0 && j < 9))
					{
						if (mineFound(j, i))
							Counter++;
					}
				}
			}
			return Counter;
		}
	
//	reveals all gray cells that have no mines nearby until it finds cells that have mines nearby
	public void dominoEffect(int x, int y) 
	{
		if ((x >= 0 && x < 9) && (y >= 0 && y < 9)) 
		{
			if (!((mineFound(x, y) == true) || (grayCell(x, y) == true))) 
			{
				colorArray[x][y] = Color.GRAY;
				if (numbersInCells(x, y) > 0) 
				{
//					Do nothing!
				} else {
//	recursive method to fill all cells in four different directions that don't have mines
					dominoEffect(x + 1, y);
					dominoEffect(x - 1, y);
					dominoEffect(x, y - 1); 
					dominoEffect(x, y + 1);
				}
			}
		}
	}
	public static void gameLostMessage() 
	{
		//Simulates to save score (Does not actually save it)
		String message = JOptionPane.showInputDialog(null, "You found a mine. Try harder next time.", "FAILURE!!!!", JOptionPane.PLAIN_MESSAGE);
		{
			System.exit(0);
		}
	}
	
	public void gameWon()
	{
		int totalCells = 81;
		int gameWonCells = totalCells-totalMines;
		
		for (int i=0; i<9; i++)
		{
			for (int j=0; j<9; j++)
			{
				if (grayCell(i,j))
					gameWonCells--;
				}
			}
		if (gameWonCells == 0)
		{
			//Simulates to save score (Does not actually save it)
			String message = JOptionPane.showInputDialog(null, "You did not find a mine. You are too smart for this game.", "VICTORY!!!1!", JOptionPane.PLAIN_MESSAGE);
			{
				System.exit(0);
			}

		}
	}
}