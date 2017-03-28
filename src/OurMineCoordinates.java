import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

public class OurMineCoordinates
{
	public static boolean[][] mineField = new boolean[9][9];
	public static boolean[][] flaggedCell = new boolean[9][9];
	public static Color[][] colorArray = new Color[9][10];
	private Random generator = new Random();
	public static int totalMines = 10;
	
//	Generates the mines on the panel
	
	public static Color[][] getColorField() 
	{
		return colorArray;
	}
	public void createMines()
	{
		int setMines = 0;
		while (setMines < totalMines) 
		{
			int column = generator.nextInt(9);
			int row = generator.nextInt(9);
			if (mineField[column][row] == false) 
			{ 
				mineField[column][row] = true;
				setMines++;
				
				System.out.println("Mine has been set in mineField["+row+"]["+column+"]");
			}
		}
	}
	
	public static boolean mineFound(int x, int y)
	{
		return mineField[x][y];
	}
	
//	public static void gameLost(int x, int y)
//	{	
//		Color colorForMine = Color.BLACK;
//		for(int i = 0; i < 9; i++)
//		{
//			for(int j = 0; j < 9; j++)
//			{
//				if(mineField[i][j] == true)
//				{
//					colorArray[i][j] = colorForMine;
//				}
//			}
//		}
//	}
	
	public static void gameLostMessage()
	{
		String message = JOptionPane.showInputDialog(null, "You found a mine. Try harder next time.", "FAILURE!!!1!", JOptionPane.PLAIN_MESSAGE);
		{
			System.exit(0);
		}
	}
	
	public boolean uncoveredCell(int x, int y) {
		if (colorArray[x][y].equals(Color.GRAY)) {
			return true;
		}
		return false;
}
	
	public boolean hasMine(int x, int y) {
		return mineField[x][y];
	}
	
	public int mineIndicator(int x, int y) {  //shows how many mines are surrounding target cell
	int mineCounter = 0;

	for (int i = y - 1; i < y + 2; i++) {
		for (int j = x - 1; j < x + 2; j++) {
			if ((i >= 0 && i < 9) && (j >= 0 && j < 9))
				if (hasMine(j, i))
					mineCounter++;
		}
	}
	return mineCounter;
	}
	
	public void gameWon()
	{
		int totalCells = 81;
		int gameWonCells = totalCells-totalMines;
		
		for (int i=0; i<9; i++)
		{
			for (int j=0; j<9; j++)
			{
				if (hasMine(i,j)==false && uncoveredCell(i,j) == true)
					gameWonCells--;
				}
			}
		if (gameWonCells == 0)
		{
			String message = JOptionPane.showInputDialog(null, "You did not find a mine. You are too smart for this game.", "VICTORY!!!1!", JOptionPane.PLAIN_MESSAGE);
			{
				System.exit(0);
			}
//		}
	}
}
}
