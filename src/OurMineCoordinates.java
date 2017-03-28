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
	
	
	public static Color[][] getColorField() {
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
				
				System.out.println("Mine has been set in mineField["+row+"]["+column+"]"); 
			}
		}
	}
	public boolean mineFound(int x, int y)
	{
		return mineField[x][y];
	}
	
	public boolean uncoveredCell(int x, int y) {
		if (colorArray[x][y].equals(Color.GRAY)) {
			return true;
		}
		return false;
	}
	
	public int numbersInCells(int x, int y){
			int Counter = 0;

			for (int i = y - 1; i < y + 2; i++) {
				for (int j = x - 1; j < x + 2; j++) {
					
					if ((i >= 0 && i < 9) && (j >= 0 && j < 9)){
						if (mineFound(j, i))
							Counter++;
					}
				}
			}
			return Counter;
		}
	}