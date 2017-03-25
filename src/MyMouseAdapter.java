import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.plaf.ColorUIResource;

public class MyMouseAdapter extends MouseAdapter {
	private Random generator = new Random();
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			//Do nothing
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
//						if ((gridX == 0) || (gridY == 0)) {
							Color newColor = Color.GRAY;
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							myPanel.repaint();
//						} else {
//							//On the grid other than on the left column and on the top row:
//							Color newColor = Color.GRAY;
//							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
//							myPanel.repaint();
//						}
					}
				}
			}
			myPanel.repaint();
			break;
		case 3:		Component c1 = e.getComponent();
		while (!(c1 instanceof JFrame)) {
			c1 = c1.getParent();
			if (c1 == null) {
				return;
			}
		}
		JFrame myFrame1 = (JFrame)c1;
		MyPanel myPanel1 = (MyPanel) myFrame1.getContentPane().getComponent(0); 
		Insets myInsets1 = myFrame1.getInsets();
		int x12 = myInsets1.left;
		int y12 = myInsets1.top;
		e.translatePoint(-x12, -y12);
		int x3 = e.getX();
		int y3 = e.getY();
		myPanel1.x = x3;
		myPanel1.y = y3;
		int gridX1 = myPanel1.getGridX(x3, y3);
		int gridY1 = myPanel1.getGridY(x3, y3);
		myPanel1.repaint();
		
		if(gridX1 >= 0 && gridX1 <= 8 && gridY1 >= 0 && gridY1 <= 8) {

			if(myPanel1.colorArray[gridX1][gridY1].equals(Color.WHITE)){

				myPanel1.colorArray[gridX1][gridY1] = Color.RED;
				myPanel1.repaint();
			}

			else if(myPanel1.colorArray[gridX1][gridY1].equals(Color.BLACK) || myPanel1.colorArray[gridX1][gridY1].equals(Color.GRAY) || myPanel1.colorArray[gridX1][gridY1].equals(Color.YELLOW)){

				// Do nothing.
			}
			else {

				myPanel1.colorArray[gridX1][gridY1] = Color.WHITE;
				myPanel1.repaint();

			}
		}
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
}
